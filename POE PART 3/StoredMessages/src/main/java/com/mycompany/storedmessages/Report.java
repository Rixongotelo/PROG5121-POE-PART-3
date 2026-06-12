/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sendingmessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author nseke
 */
public class Report {
    // The class under test
    private StoredMessages manager;
    private StoredMessages msg1;
    private StoredMessages msg2;
    private StoredMessages msg3;
    private StoredMessages msg4;
 
    // ----------------------------------------------------------------
    // @BeforeEach runs before every single test, giving each a
    // clean manager loaded with the 4 test messages.
    // ----------------------------------------------------------------
    @BeforeEach
    public void setUp() {
        manager = new StoredMessages();
 
        // Message 1 — Sent
        msg1 = new StoredMessages(
            "+27838884567",
            "Where are you? You are late! I have asked you to be on time.",
            "Sent",
            "0838884561",
            "Test Message 1"
        );
 
        // Message 2 — Sent
        msg2 = new StoredMessages(
            "+27838884567",
            "Ok, I am leaving without you.",
            "Sent",
            "0838884562",
            "Test Message 2"
        );
 
        // Message 3 — Stored
        msg3 = new StoredMessages(
            "+27838884567",
            "Did you get the cake?",
            "Stored",
            "0838884563",
            "Test Message 3"
        );
 
        // Message 4 — Sent (messageID used in search test: 0838884567)
        msg4 = new StoredMessages(
            "+27838884567",
            "It is dinner time!",
            "Sent",
            "0838884567",
            "Test Message 4"
        );
 
        manager.addMessage(msg1);
        manager.addMessage(msg2);
        manager.addMessage(msg3);
        manager.addMessage(msg4);
    }
 
    // ----------------------------------------------------------------
    // Test 1: Sent Messages array correctly populated
    // Test Data:  messages 1-4
    // Expected:   "Did you get the cake?", "It is dinner time!"
    // ----------------------------------------------------------------
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        List<String> sentMessages = manager.getSentMessageTexts();
 
        assertTrue(
            sentMessages.contains("Did you get the cake?"),
            "Sent messages should contain: Did you get the cake?"
        );
        assertTrue(
            sentMessages.contains("It is dinner time!"),
            "Sent messages should contain: It is dinner time!"
        );
    }
 
    // ----------------------------------------------------------------
    // Test 2: Display the longest message
    // Test Data:  messages 1-4
    // Expected:   "Where are you? You are late! I have asked you to be on time."
    // ----------------------------------------------------------------
    @Test
    public void testDisplayLongestMessage() {
        String longest = manager.getLongestMessage();
 
        assertEquals(
            "Where are you? You are late! I have asked you to be on time.",
            longest,
            "getLongestMessage() should return the text of message 1"
        );
    }
 
    // ----------------------------------------------------------------
    // Test 3: Search for messageID
    // Test Data:  message 4, ID = "0838884567"
    // Expected:   "It is dinner time!"
    // ----------------------------------------------------------------
    @Test
    public void testSearchByMessageId() {
        String result = manager.searchByMessageId("0838884567");
 
        assertEquals(
            "It is dinner time!",
            result,
            "Searching by ID '0838884567' should return: It is dinner time!"
        );
    }
 
    // ----------------------------------------------------------------
    // Test 4: Search all messages sent or stored for a recipient
    // Test Data:  +27838884567
    // Expected:   MSG1 and MSG2 texts are both returned
    // ----------------------------------------------------------------
    @Test
    public void testSearchByRecipient() {
        List<String> results = manager.searchByRecipient("+27838884567");
 
        assertTrue(
            results.contains("Where are you? You are late! I have asked you to be on time."),
            "Recipient search should include message 1"
        );
        assertTrue(
            results.contains("Ok, I am leaving without you."),
            "Recipient search should include message 2"
        );
    }
 
    // ----------------------------------------------------------------
    // Test 5: Delete a message using a message hash
    // Test Data:  "Test Message 2"
    // Expected:   Confirmation that message 2 was deleted;
    //             message 2 no longer in the list
    // ----------------------------------------------------------------
    @Test
    public void testDeleteMessageByHash() {
        String result = manager.deleteByHash("Test Message 2");
 
        assertEquals(
            "Message: \"Ok, I am leaving without you.\" successfully deleted.",
            result,
            "deleteByHash() should confirm message 2 was removed"
        );
 
        // Verify msg2 is truly gone
        List<String> remaining = manager.getAllMessageTexts();
        assertFalse(
            remaining.contains("Ok, I am leaving without you."),
            "Message 2 should no longer appear after deletion"
        );
    }
 
    // ----------------------------------------------------------------
    // Test 6: Display report
    // Expected:   Report contains MessageHash, Recipient, and Message
    //             for each sent message
    // ----------------------------------------------------------------
    @Test
    public void testDisplayReport() {
        List<String> report = manager.getReport();
 
        // Report must include message 1's hash, recipient, and text
        assertTrue(
            report.stream().anyMatch(line ->
                line.contains("Test Message 1") &&
                line.contains("+27838884567") &&
                line.contains("Where are you? You are late! I have asked you to be on time.")),
            "Report should contain hash, recipient, and message text for message 1"
        );
 
        // Report must include message 4's hash, recipient, and text
        assertTrue(
            report.stream().anyMatch(line ->
                line.contains("Test Message 4") &&
                line.contains("+27838884567") &&
                line.contains("It is dinner time!")),
            "Report should contain hash, recipient, and message text for message 4"
        );
    }
}
