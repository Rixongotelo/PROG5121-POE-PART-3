/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.storedmessages;

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
public class StoredMessagesTest {
    
    public StoredMessagesTest() {
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
     * Test of loadStoredMessages method, of class StoredMessages.
     */
    @Test
    public void testLoadStoredMessages() {
        System.out.println("loadStoredMessages");
        String filePath = "";
        StoredMessages instance = new StoredMessages();
        instance.loadStoredMessages(filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storedMessagesMenu method, of class StoredMessages.
     */
    @Test
    public void testStoredMessagesMenu() {
        System.out.println("storedMessagesMenu");
        StoredMessages instance = new StoredMessages();
        instance.storedMessagesMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class StoredMessages.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        StoredMessages instance = new StoredMessages();
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class StoredMessages.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        StoredMessages instance = new StoredMessages();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlag method, of class StoredMessages.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        StoredMessages instance = new StoredMessages();
        String expResult = "";
        String result = instance.getFlag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageId method, of class StoredMessages.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        StoredMessages instance = new StoredMessages();
        String expResult = "";
        String result = instance.getMessageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class StoredMessages.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        StoredMessages instance = new StoredMessages();
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
