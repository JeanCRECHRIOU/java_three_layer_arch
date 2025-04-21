package com.jcrechriou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jcrechriou.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Pas besoin d'implémentation, Spring Data JPA s'en charge
}
