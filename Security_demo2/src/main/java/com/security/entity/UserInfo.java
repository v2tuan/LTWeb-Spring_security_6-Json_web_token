package com.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Tự động sinh getter và setter
@AllArgsConstructor // Tự động sinh constructor có đầy đủ tham số
@NoArgsConstructor // Tự động sinh constructor không tham số
public class UserInfo {

    @Id // Đánh dấu trường này là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private int id;

    private String name;
    private String email;
    private String password;
    private String roles;
}