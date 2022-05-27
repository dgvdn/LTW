package com.hotel.controller;

import com.hotel.model.Account;
import com.hotel.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegisterController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/login")
    public String formlogin(){
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("email")String email, @ModelAttribute("password")String password){
//        Account account = accountRepository.findByEmail(email);
//        return "login_success";
//    }

    @GetMapping("/register")
    public String formRegister(Model model){
        model.addAttribute("account", new Account());
        return ("register");
    }
    @PostMapping("/register")
    public String register(Account account){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);

        accountRepository.save(account);
        return "register_sucess";
    }
}
