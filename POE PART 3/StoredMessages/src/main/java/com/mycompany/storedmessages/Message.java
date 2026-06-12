/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storedmessages;

/**
 *
 * @author nseke
 */
public class Message {
     private final String recipient;
    private final String message;
    private final String flag;
    private final String messageId;
    private final String messageHash;

    public Message(String recipient, String message, String flag, String messageId, String messageHash) {
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.messageId = messageId;
        this.messageHash = messageHash;
    }

    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getFlag() { return flag; }
    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
}  
