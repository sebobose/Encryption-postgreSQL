package org.sosa.encryptionpostgresql.controller;

import org.sosa.encryptionpostgresql.model.Message;
import org.sosa.encryptionpostgresql.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/data")
    public ResponseEntity<Map<String, Object>> storeData(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String message = request.get("message");

        messageService.storeMessage(username, message);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/data")
    public ResponseEntity<Map<String, Object>> getDecryptedData() {
        List<Message> dataList = messageService.getAllMessages();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", dataList);

        return ResponseEntity.ok(response);
    }
}
