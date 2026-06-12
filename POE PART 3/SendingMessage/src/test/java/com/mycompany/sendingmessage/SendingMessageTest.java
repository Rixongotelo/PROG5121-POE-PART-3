/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.sendingmessage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nseke
 */
public class SendingMessageTest {
    
    public SendingMessageTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkMessageID method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        SendingMessage instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.sentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        SendingMessage instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        SendingMessage instance = null;
        instance.storeMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessageDetails method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testDisplayMessageDetails() {
        System.out.println("displayMessageDetails");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.displayMessageDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageText method, of class SendingMessage.
     */
    @org.junit.jupiter.api.Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        SendingMessage instance = null;
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
