package com.spotify.demo.service.impl;

import com.spotify.demo.exception.UserException;
import com.spotify.demo.model.dto.UsersDTO;
import com.spotify.demo.model.entity.Users;
import com.spotify.demo.repository.UsersRepository;
import com.spotify.demo.service.UsersService;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(ModelMapper modelMapper, UsersRepository usersRepository) {
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }

    @Transactional
    @Override
    public UsersDTO saveUser(UsersDTO userDTO) {
        try {
            Users userEntity = modelMapper.map(userDTO, Users.class);
            return modelMapper.map(usersRepository.save(userEntity), UsersDTO.class);
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public List<UsersDTO> getUsers() {
        try {
            List<Users> usersEntities =  usersRepository.findAll();
            return usersEntities.stream()
                    .map(userEntity -> modelMapper.map(userEntity, UsersDTO.class))
                    .collect(Collectors.toList());
        } catch (DataAccessException e){
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}