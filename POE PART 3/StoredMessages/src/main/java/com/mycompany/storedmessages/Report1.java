package com.mycompany.storedmessages;

/**
 * @author nseke
 */
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import org.json.*;

public class StoredMessages {
    private String recipient;
    private String message;
    private String flag;
    private String messageId;
    private String messageHash;
    
    public StoredMessages() {}
    
    public StoredMessages(String recipient, String message, String flag,
                          String messageId, String messageHash) {
        this.recipient   = recipient;
        this.message     = message;
        this.flag        = flag;
        this.messageId   = messageId;
        this.messageHash = messageHash;
    }

    // ----------------------------------------------------------------
    // Getters
    // ----------------------------------------------------------------
    public String getRecipient()   { return recipient; }
    public String getMessage()     { return message; }
    public String getFlag()        { return flag; }
    public String getMessageId()   { return messageId; }
    public String getMessageHash() { return messageHash; }

    
    // Message lists (used by the manager instance)
    
    private final List<StoredMessages> sentMessages        = new ArrayList<>();
    private List<StoredMessages>       storedMessages      = new ArrayList<>();
    private List<StoredMessages>       disregardedMessages = new ArrayList<>();
    
    // Load messages from a JSON file
    
    public void loadStoredMessages(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                StoredMessages msg = new StoredMessages(
                    obj.getString("recipient"),
                    obj.getString("message"),
                    obj.getString("flag"),
                    obj.getString("messageId"),
                    obj.getString("messageHash")
                );
                addMessage(msg);
            }
        } catch (IOException e) {
            System.err.println("Error loading messages from file: " + e.getMessage());
        }
    }

    // Add a message to the correct list based on its flag
 
    public void addMessage(StoredMessages msg) {
        switch (msg.getFlag()) {
            case "Sent":      sentMessages.add(msg);        break;
            case "Stored":    storedMessages.add(msg);      break;
            case "Disregard": disregardedMessages.add(msg); break;
            default: System.out.println("Unknown flag: " + msg.getFlag());
        }
    }

    // Console Menu

    public void storedMessagesMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Stored Messages Menu:");
        System.out.println("1. Display all stored messages");
        System.out.println("2. Display longest stored message");
        System.out.println("3. Search by message ID");
        System.out.println("4. Search by recipient");
        System.out.println("5. Delete message by hash");
        System.out.println("6. Display report");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: displayAllStored();       break;
            case 2: displayLongestStored();   break;
            case 3: searchByMessageIdMenu(sc); break;
            case 4: searchByRecipientMenu(sc); break;
            case 5: deleteByHashMenu(sc);      break;
            case 6: displayReport();           break;
            default: System.out.println("Invalid option.");
        }
    }

    
    // Private console print methods (used by the menu)
 
    private void displayAllStored() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        for (StoredMessages msg : storedMessages) {
            System.out.println("Recipient: " + msg.getRecipient()
                             + " | Message: " + msg.getMessage());
        }
    }

    private void displayLongestStored() {
        String longest = getLongestMessage();
        if (longest != null) {
            System.out.println("Longest Message: " + longest);
        } else {
            System.out.println("No messages found.");
        }
    }

    private void searchByMessageIdMenu(Scanner sc) {
        System.out.print("Enter Message ID: ");
        String id = sc.nextLine();
        String result = searchByMessageId(id);
        if (result != null) {
            System.out.println("Message: " + result);
        } else {
            System.out.println("Message ID not found.");
        }
    }

    private void searchByRecipientMenu(Scanner sc) {
        System.out.print("Enter Recipient: ");
        String recipient = sc.nextLine();
        List<String> results = searchByRecipient(recipient);
        if (results.isEmpty()) {
            System.out.println("No messages found for recipient: " + recipient);
        } else {
            for (String msg : results) {
                System.out.println("Message: " + msg);
            }
        }
    }

    private void deleteByHashMenu(Scanner sc) {
        System.out.print("Enter Message Hash: ");
        String hash = sc.nextLine();
        System.out.println(deleteByHash(hash));
    }

    private void displayReport() {
        System.out.println("Stored Messages Report:");
        List<String> report = getReport();
        if (report.isEmpty()) {
            System.out.println("No sent messages.");
            return;
        }
        for (String line : report) {
            System.out.println(line);
        }
    }
    /** Returns message text for all sent messages. */
    public List<String> getSentMessageTexts() {
        List<String> texts = new ArrayList<>();
        for (StoredMessages msg : sentMessages) {
            texts.add(msg.getMessage());
        }
        return texts;
    }

    /** Returns the text of the longest message across all lists. */
    public String getLongestMessage() {
        List<StoredMessages> all = new ArrayList<>();
        all.addAll(sentMessages);
        all.addAll(storedMessages);
        all.addAll(disregardedMessages);
        return all.stream()
            .max(Comparator.comparingInt(m -> m.getMessage().length()))
            .map(StoredMessages::getMessage)
            .orElse(null);
    }

    /** Returns the message text matching the given ID, or null if not found. */
    public String searchByMessageId(String id) {
        List<StoredMessages> all = new ArrayList<>();
        all.addAll(sentMessages);
        all.addAll(storedMessages);
        for (StoredMessages msg : all) {
            if (msg.getMessageId().equals(id)) {
                return msg.getMessage();
            }
        }
        return null;
    }

    /** Returns all message texts for a given recipient across sent and stored lists. */
    public List<String> searchByRecipient(String recipient) {
        List<String> results = new ArrayList<>();
        List<StoredMessages> all = new ArrayList<>();
        all.addAll(sentMessages);
        all.addAll(storedMessages);
        for (StoredMessages msg : all) {
            if (msg.getRecipient().equals(recipient)) {
                results.add(msg.getMessage());
            }
        }
        return results;
    }

    /** Deletes a message by hash; returns a confirmation or not-found string. */
    public String deleteByHash(String hash) {
        List<StoredMessages> all = new ArrayList<>();
        all.addAll(sentMessages);
        all.addAll(storedMessages);
        for (StoredMessages msg : all) {
            if (msg.getMessageHash().equals(hash)) {
                String text = msg.getMessage();
                sentMessages.remove(msg);
                storedMessages.remove(msg);
                return "Message: \"" + text + "\" successfully deleted.";
            }
        }
        return "No message found with hash: " + hash;
    }

    /** Returns report lines containing hash, recipient, and message for all sent messages. */
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        for (StoredMessages msg : sentMessages) {
            report.add("Hash: "         + msg.getMessageHash()
                     + " | Recipient: " + msg.getRecipient()
                     + " | Message: "   + msg.getMessage());
        }
        return report;
    }

    /** Returns all message texts across sent and stored lists (used to verify deletions). */
    public List<String> getAllMessageTexts() {
        List<String> texts = new ArrayList<>();
        for (StoredMessages msg : sentMessages)   texts.add(msg.getMessage());
        for (StoredMessages msg : storedMessages) texts.add(msg.getMessage());
        return texts;
    }
}