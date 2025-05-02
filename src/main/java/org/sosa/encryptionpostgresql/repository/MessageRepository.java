package org.sosa.encryptionpostgresql.repository;

import org.sosa.encryptionpostgresql.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "INSERT INTO messages (sender, plaintext_message) VALUES (:sender, :message) RETURNING id",
            nativeQuery = true)
    Long saveMessage(@Param("sender") String sender, @Param("message") String message);

    @Query(value = "SELECT id, sender, decrypt_message(encrypted_message) AS plaintext_message, encrypted_message, created_at " +
            "FROM messages ORDER BY created_at DESC",
            nativeQuery = true)
    List<Message> getAllMessages();
}