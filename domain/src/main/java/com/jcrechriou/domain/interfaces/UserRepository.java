package com.jcrechriou.domain.interfaces;

import com.jcrechriou.domain.entities.User;
import java.util.List;

import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User> getById(Long id);
    User save(User user);
    void delete(User user);
}
