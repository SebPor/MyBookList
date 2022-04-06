package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
