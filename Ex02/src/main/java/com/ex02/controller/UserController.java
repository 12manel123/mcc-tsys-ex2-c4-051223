package com.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex02.dto.User;
import com.ex02.service.UserService;


@RestController
@RequestMapping("ex2")
public class UserController {
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public String processRegistration(@RequestBody User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Autenticación exitosa");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticación fallida");
        }
    }
    @PostMapping("/updateProfile")
    public ResponseEntity<String> updateProfile(@RequestBody User updatedUser) {
        User currentUser = userService.findByUsername(updatedUser.getUsername());

        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        currentUser.setEmail(updatedUser.getEmail());
        userService.updateUserProfile(currentUser);

        return ResponseEntity.ok("Perfil actualizado exitosamente");
    }
    
    @PostMapping("/logout/{username}")
    public ResponseEntity<String> logout(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        return ResponseEntity.ok("Logout exitoso para el usuario: " + username);
    }
}
