package com.example.Legnomagus.service;

import jakarta.servlet.http.HttpSession;

public interface AdminService {
    Boolean controlloLogin(String username, String password, HttpSession session);
}
