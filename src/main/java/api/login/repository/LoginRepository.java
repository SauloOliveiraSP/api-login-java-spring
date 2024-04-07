package api.login.repository;

import api.login.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UsuarioModel, Long> {
    // Método para buscar um usuário por e-mail e senha
    @Query("SELECT u FROM UsuarioModel u WHERE u.email = :email AND u.senha = :senha")
    UsuarioModel findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
