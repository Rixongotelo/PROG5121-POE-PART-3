/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.storedmessages;
/**
 *
 * @author nseke
 */
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import org.json.*;

public class StoredMessages {
    // ADD: private fields to hold each message's datanew
    private String recipient;
    private String message;
    private String flag;
    private String messageId;
    private String messageHash;

    // ADD: default constructor (used to create the manager instance)new
    public StoredMessages() {}

    // ADD: parameterised constructor used in loadStoredMessages()new
    public StoredMessages(String recipient, String message, String flag,
                          String messageId, String messageHash) {
        this.recipient   = recipient;
        this.message     = message;
        this.flag        = flag;
        this.messageId   = messageId;
        this.messageHash = messageHash;
    }

    
    public String getRecipient()   { return recipient; }
    public String getMessage()     { return message; }
    public String getFlag()        { return flag; }  
    public String getMessageId()   { return messageId; }
    public String getMessageHash() { return messageHash; }
    
    private final List<StoredMessages> sentMessages = new ArrayList<>();
    private List<StoredMessages> storedMessages = new ArrayList<>();
    private List<StoredMessages> disregardedMessages = new ArrayList<>();

    // Load stored messages from JSON file
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

                switch (msg.getFlag()) {
                    case "Sent": sentMessages.add(msg); break;
                    case "Stored": storedMessages.add(msg); break;
                    case "Disregard": disregardedMessages.add(msg); break;
                }
            }
        } catch (IOException e) {
        }
    }

    // Menu option: Stored Messages
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
            case 1: displayAllStored(); break;
            case 2: displayLongestStored(); break;
            case 3: searchByMessageId(sc); break;
            case 4: searchByRecipient(sc); break;
            case 5: deleteByHash(sc); break;
            case 6: displayReport(); break;
        }
    }

    private void displayAllStored() {
        for (StoredMessages msg : storedMessages) {
            System.out.println("Recipient: " + msg.getRecipient() + " | Message: " + msg.getMessage());
        }
    }

    private void displayLongestStored() {
        StoredMessages longest = storedMessages.stream()
            .max(Comparator.comparingInt(m -> m.getMessage().length()))
            .orElse(null);
        if (longest != null) {
            System.out.println("Longest Message: " + longest.getMessage());
        }
    }

    private void searchByMessageId(Scanner sc) {
        System.out.print("Enter Message ID: ");
        String id = sc.nextLine();
        for (StoredMessages msg : storedMessages) {
            if (msg.getMessageId().equals(id)) {
                System.out.println("Recipient: " + msg.getRecipient() + " | Message: " + msg.getMessage());
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    private void searchByRecipient(Scanner sc) {
        System.out.print("Enter Recipient: ");
        String Recipient = sc.nextLine();
        for (StoredMessages msg : storedMessages) {
            if (msg.getRecipient().equals(Recipient)) {
                System.out.println("Message: " + msg.getMessage());
            }
        }
    }

    private void deleteByHash(Scanner sc) {
        System.out.print("Enter Message Hash: ");
        String hash = sc.nextLine();
        storedMessages.removeIf(msg -> msg.getMessageHash().equals(hash));
        System.out.println("Message successfully deleted.");
    }

    private void displayReport(){
        System.out.println("Stored Messages Report:");
        for (StoredMessages msg : storedMessages) {
            System.out.println("Hash: " + msg.getMessageHash() +
                               " | Recipient: " + msg.getRecipient() +
                               " | Message: " + msg.getMessage());
        }
    }
}