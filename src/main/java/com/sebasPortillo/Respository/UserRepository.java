package com.sebasPortillo.Respository;

import com.sebasPortillo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query(value = "delete from comentario where fk_usuario = :id", nativeQuery = true)
    public void deleteUserReferencesComentario(Long id);

    @Modifying
    @Query(value = "delete from usuario_libro where fk_usuario = :id", nativeQuery = true)
    public void deleteUserReferencesUserBook(Long id);

    @Query(value = "select * from usuario u where u.nick = :nick", nativeQuery = true)
    public User findUserByNick(String nick);
}
