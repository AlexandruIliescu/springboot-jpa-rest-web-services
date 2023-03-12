package com.spotify.demo.service;

import com.spotify.demo.model.dto.UsersDTO;
import java.util.List;

public interface UserService {

    UsersDTO saveUser(UsersDTO userDTO);

    List<UsersDTO> getUsers();
}