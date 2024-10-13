package br.com.fiap.semaforos.repository;

import br.com.fiap.semaforos.model.Controladora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControladoraRepository extends JpaRepository<Controladora, Long> {
}
