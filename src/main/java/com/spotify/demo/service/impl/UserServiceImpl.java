package com.spotify.demo.service.impl;

import com.spotify.demo.exception.UserException;
import com.spotify.demo.model.dto.UsersDTO;
import com.spotify.demo.model.entity.Users;
import com.spotify.demo.repository.UserRepository;
import com.spotify.demo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UsersDTO saveUser(UsersDTO userDTO) {
        try {
            Users userEntity = modelMapper.map(userDTO, Users.class);
            return modelMapper.map(userRepository.save(userEntity), UsersDTO.class);
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public List<UsersDTO> getUsers() {
        try {
            List<Users> usersEntities =  userRepository.findAll();
            return usersEntities.stream()
                    .map(userEntity -> modelMapper.map(userEntity, UsersDTO.class))
                    .collect(Collectors.toList());
        } catch (DataAccessException e){
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}