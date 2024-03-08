package com.example.Legnomagus.controller;

import com.example.Legnomagus.dao.AdminDao;
import com.example.Legnomagus.dao.CategoriaDao;
import com.example.Legnomagus.dao.ProdottoDao;
import com.example.Legnomagus.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getPage(HttpSession session,
                          @RequestParam(name = "errore", required = false)String errore,
                          Model model){
        if (session.getAttribute("admin") != null){
            return "redirect:/";
        }
        model.addAttribute("errore",errore);
        return "login";
    }
    @PostMapping
    public String formManager(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              HttpSession session){
        if (!adminService.controlloLogin(username, password, session)){
        return "redirect:/login?errore";
        }else {
            return "redirect:/";
        }
    }

}
