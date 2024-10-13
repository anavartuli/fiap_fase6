package br.com.fiap.semaforos.repository;

import br.com.fiap.semaforos.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {
}
