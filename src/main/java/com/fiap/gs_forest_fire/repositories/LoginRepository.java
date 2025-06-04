package com.fiap.gs_forest_fire.repositories;

import com.fiap.gs_forest_fire.domain.entities.Equipment;
import com.fiap.gs_forest_fire.domain.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String email);
    Optional<Login> findByEmailAndPassword(String email, String password);
}
