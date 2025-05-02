package org.sosa.encryptionpostgresql.service;

import org.sosa.encryptionpostgresql.model.Message;
import org.sosa.encryptionpostgresql.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public void storeMessage(String sender, String message) {
        repository.saveMessage(sender, message);
    }

    public List<Message> getAllMessages() {
        return repository.getAllMessages();
    }

}