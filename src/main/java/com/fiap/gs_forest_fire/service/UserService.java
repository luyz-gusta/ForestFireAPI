package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.user.RequestUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.ResponseUserDTO;
import com.fiap.gs_forest_fire.domain.dto.user.UpdateUserDTO;
import com.fiap.gs_forest_fire.domain.entities.Login;
import com.fiap.gs_forest_fire.domain.entities.User;
import com.fiap.gs_forest_fire.infra.mapper.user.UserMapper;
import com.fiap.gs_forest_fire.repositories.LoginRepository;
import com.fiap.gs_forest_fire.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final LoginRepository loginRepository;
    private final UserMapper mapper;
    private final LoginService loginService;


    public List<ResponseUserDTO> listAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    public List<ResponseUserDTO> listUsersActive() {
        return repository
                .findAllByStatusTrue()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    public ResponseUserDTO listUserById(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toUserResponse(user);
    }

    public ResponseUserDTO saveUser(RequestUserDTO userDTO) {
        loginService.validEmail(userDTO.getEmail());

        Login login = new Login(userDTO);
        User user = new User(userDTO, login);

        repository.save(user);
        return mapper.toUserResponse(user);
    }

    @Transactional
    public ResponseUserDTO editUser(UpdateUserDTO userDTO) {
        User user = repository
                .findById(userDTO.getIdUser())
                .orElseThrow(EntityNotFoundException::new);

        user.setUpdatedUser(userDTO);
        return mapper.toUserResponse(user);
    }

    @Transactional
    public ResponseUserDTO editUserStatus(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setStatus(!user.getStatus());

        return mapper.toUserResponse(user);
    }

    @Transactional
    public void excludeUser(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }
}
