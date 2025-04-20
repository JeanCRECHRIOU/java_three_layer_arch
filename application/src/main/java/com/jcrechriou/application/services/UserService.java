package com.jcrechriou.application.services;

import com.jcrechriou.domain.entities.User;
import com.jcrechriou.infra.entities.UserEntity;
import com.jcrechriou.infra.repositories.UserRepositoryJpa;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepositoryJpa userRepositoryJpa;

    public UserService(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public List<UserEntity> getAllUsers() {
        return userRepositoryJpa.findAll();
    }
}
