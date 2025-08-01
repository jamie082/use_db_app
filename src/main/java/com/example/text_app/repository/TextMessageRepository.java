package com.example.text_app.repository;

import com.example.text_app.model.TextMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMessageRepository extends JpaRepository<TextMessage, Long> {
    // JpaRepository provides all basic CRUD operations automatically!
    // You don't need to add any methods here for this project.
}