package com.fiap.gs_forest_fire.service;

import com.fiap.gs_forest_fire.domain.dto.login.ResponseLoginDTO;
import com.fiap.gs_forest_fire.domain.entities.Login;
import com.fiap.gs_forest_fire.domain.entities.Team;
import com.fiap.gs_forest_fire.domain.entities.User;
import com.fiap.gs_forest_fire.repositories.LoginRepository;
import com.fiap.gs_forest_fire.repositories.TeamRepository;
import com.fiap.gs_forest_fire.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final LoginRepository repository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public void validEmail(String email) {
        Optional<Login> existingLogin = repository
                .findByEmail(email)
                .stream()
                .findFirst();
        if (existingLogin.isPresent()) {
            throw new DuplicateKeyException("email");
        }
    }

    public ResponseLoginDTO login(String email, String password){
        Optional<Login> loginData = repository
                .findByEmailAndPassword(email, password)
                .stream()
                .findFirst();
        if (loginData.isEmpty()) {
            throw new InvalidDataAccessApiUsageException("Email não encontrado!");
        }

        ResponseLoginDTO response = new ResponseLoginDTO();
        response.setIdLogin(loginData.get().getIdLogin());

        if(loginData.get().getType() == "user"){
            User userData = userRepository.findByLogin(loginData.get());
            response.setUser(userData);
        }else{
            Team teamData = teamRepository.findByLogin(loginData.get());
            response.setTeam(teamData);
        }

        return response;
    }
}
