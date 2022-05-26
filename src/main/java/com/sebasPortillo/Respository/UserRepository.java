package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query(value = "delete from comentario where fk_usuario = :id; delete from usuario_libro where fk_usuario = :id;", nativeQuery = true)
    public void deleteUserReferences(Long id);
}
