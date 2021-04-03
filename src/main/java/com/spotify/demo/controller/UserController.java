package com.spotify.demo.controller;

import com.spotify.demo.model.dto.UsersDTO;
import com.spotify.demo.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }
//custom object for response
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> saveUser(@RequestBody UsersDTO userDTO) {
        return ResponseEntity.ok(usersService.saveUser(userDTO));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersDTO>> getUsers() {
        return ResponseEntity.ok(usersService.getUsers());
    }
}