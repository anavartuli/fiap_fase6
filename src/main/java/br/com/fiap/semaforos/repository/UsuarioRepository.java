package br.com.fiap.semaforos.repository;

import br.com.fiap.semaforos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    Optional<Usuario> buscarUsuarioPeloNome(@Param("nome") String name);
}
