package com.jcrechriou.infra.mappers;

import com.jcrechriou.domain.entities.User;
import com.jcrechriou.infra.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getName());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getName());
    }
}
