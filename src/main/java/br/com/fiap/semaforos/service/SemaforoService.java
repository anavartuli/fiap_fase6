package br.com.fiap.semaforos.service;

import br.com.fiap.semaforos.dto.SemaforoCadastroDto;
import br.com.fiap.semaforos.dto.SemaforoExibicaoDto;
import br.com.fiap.semaforos.exception.RegistroNaoEncontradoException;
import br.com.fiap.semaforos.model.Semaforo;
import br.com.fiap.semaforos.repository.SemaforoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public SemaforoExibicaoDto gravar(SemaforoCadastroDto semaforoCadastroDto) {
        Semaforo semaforo = new Semaforo();
        BeanUtils.copyProperties(semaforoCadastroDto, semaforo);
        return new SemaforoExibicaoDto(semaforoRepository.save(semaforo));
    }

    public SemaforoExibicaoDto buscarPeloId(Long id) {
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(id);
        if (semaforoOptional.isPresent()) {
            return new SemaforoExibicaoDto(semaforoOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Semaforo não existe!");
        }
    }

    //Implementa paginação do JPA
    public Page<SemaforoExibicaoDto> listarTodosOsSemaforos(Pageable paginacao) {
        return semaforoRepository
                .findAll(paginacao)
                .map(SemaforoExibicaoDto::new);
    }

    public SemaforoExibicaoDto atualizar(Semaforo semaforo) {
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(semaforo.getCdSemaforo());
        if (semaforoOptional.isPresent()) {
            return new SemaforoExibicaoDto(semaforoRepository.save(semaforo));
        } else {
            throw new RegistroNaoEncontradoException("Semaforo não existe!");
        }
    }

    public void excluir(Long id) {
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(id);
        if (semaforoOptional.isPresent()) {
            semaforoRepository.delete(semaforoOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Semaforo não existe!");
        }
    }

}
