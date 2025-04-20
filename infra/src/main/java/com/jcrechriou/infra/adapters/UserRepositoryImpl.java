package com.jcrechriou.infra.adapters;

import com.jcrechriou.domain.entities.User;
import com.jcrechriou.domain.interfaces.UserRepository;
import com.jcrechriou.infra.entities.UserEntity;
import com.jcrechriou.infra.mappers.UserMapper;
import com.jcrechriou.infra.repositories.UserRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;
    private final UserMapper mapper;

    public UserRepositoryImpl(
            UserRepositoryJpa userRepositoryJpa,
            UserMapper mapper) {
        this.userRepositoryJpa = userRepositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public List<User> getAll() {
        return userRepositoryJpa.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepositoryJpa.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = userRepositoryJpa.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void delete(User user) {
        userRepositoryJpa.delete(mapper.toEntity(user));
    }
}
