/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sendingmessage;

/**
 *
 * @author nseke
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SendingMessage {

    // Variables for the message details
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Static variable keeps track of total messages sent
    private static int totalMessages = 0;

    // ArrayList stores all sent messages while program runs
    private static ArrayList<String> sentMessages = new ArrayList<>();

    // Constructor
    public SendingMessage(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        // Automatically generate the hash
        this.messageHash = createMessageHash();
    }
    // Checks if Message ID is NOT more than 10 characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }
    // Validates recipient cellphone number
    // Must:
    // Start with +
    // Be no more than 10 characters after country code
    public String checkRecipientCell() {

        if (recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }
    }
    // Creates message hash
    // Example: 00:0:HITHERE
    public String createMessageHash() {

        // First 2 characters of message ID
        String firstTwo = messageID.substring(0, 2);

        // Split message into words
        String[] words = messageText.split(" ");

        // First and last words
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        // Build hash
        return firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
    }
    // Allows user to Send, Store or Discard message
    public String sentMessage() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose an option:");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message");

        int choice = input.nextInt();

        switch (choice) {

            case 1 -> {
                totalMessages++;

                // Add message to ArrayList
                sentMessages.add(messageText);

                return "Message successfully sent.";
            }

            case 2 -> {
                return "Press 0 to delete the message.";
            }

            case 3 -> {
                storeMessage();
                return "Message successfully stored.";
            }

            default -> {
                return "Invalid option selected.";
            }
        }
    }
    // Prints all sent messages
    public String printMessages() {

        String output = "";

        for (String msg : sentMessages) {
            output += msg + "\n";
        }

        return output;
    }
    // Returns total number of messages sent
    public int returnTotalMessages() {
        return totalMessages;
    }
    // Stores message (simulation)
    public void storeMessage() {
        // Using Gson (add to your pom.xml: com.google.code.gson:gson)
Gson gson = new GsonBuilder().setPrettyPrinting().create();

Map<String, Object> messageData = new LinkedHashMap<>();
messageData.put("messageID", this.messageID);
messageData.put("messageNumber", this.messageNumber);
messageData.put("messageHash", this.messageHash);
messageData.put("status", "stored");

String json = gson.toJson(messageData);
Files.writeString(Path.of("messages.json"), json);
        System.out.println("Message stored in JSON file.");
    }
    // Displays full message details
    public String displayMessageDetails() {

        return """
                --------------------------------
                Message ID: %s
                Message Hash: %s
                Recipient: %s
                Message: %s
                --------------------------------
                """.formatted(messageID, messageHash, recipient, messageText);
    }
    // Getter for message text
    public String getMessageText() {
        return messageText;
    }
}
