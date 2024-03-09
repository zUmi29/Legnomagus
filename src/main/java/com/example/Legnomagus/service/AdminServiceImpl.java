package com.example.Legnomagus.service;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.model.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public Boolean controlloLogin(String username, String password, HttpSession session) {
        Admin admin = adminDao.findByUsernameAndPassword(username, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return true;
        }
        return false;
    }
}
