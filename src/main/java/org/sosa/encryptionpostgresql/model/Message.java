package org.sosa.encryptionpostgresql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(name = "plaintext_message")
    private String plaintextMessage;

    @Column(name = "encrypted_message")
    private byte[] encryptedMessage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}