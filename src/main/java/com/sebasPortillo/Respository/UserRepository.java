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

    @Query(value = "select u.* from comentario c, usuario u where :id = u.id limit 1", nativeQuery = true)
    public User findUserByCommentId(long id);

    @Modifying
    @Query(value = "insert into sesion (idUser) values(:id)", nativeQuery = true)
    public void insertSesion(long id);

    @Query(value = "select idUser from sesion order by id desc limit 1", nativeQuery = true)
    public long recuperarSesion();
}
