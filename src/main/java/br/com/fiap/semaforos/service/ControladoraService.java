package br.com.fiap.semaforos.service;

import br.com.fiap.semaforos.dto.ControladoraCadastroDto;
import br.com.fiap.semaforos.dto.ControladoraExibicaoDto;
import br.com.fiap.semaforos.exception.RegistroNaoEncontradoException;
import br.com.fiap.semaforos.model.Controladora;
import br.com.fiap.semaforos.repository.ControladoraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ControladoraService {
    
    @Autowired
    private ControladoraRepository controladoraRepository;

    public ControladoraExibicaoDto gravar(ControladoraCadastroDto controladoraCadastroDto) {
        Controladora controladora = new Controladora();
        BeanUtils.copyProperties(controladoraCadastroDto, controladora);
        return new ControladoraExibicaoDto(controladoraRepository.save(controladora));
    }

    public ControladoraExibicaoDto buscarPeloId(Long id) {
        Optional<Controladora> controladoraOptional = controladoraRepository.findById(id);
        if (controladoraOptional.isPresent()) {
            return new ControladoraExibicaoDto(controladoraOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Controladora não existe!");
        }
    }

    //Implementa paginação do JPA
    public Page<ControladoraExibicaoDto> listarTodasAsControladoras(Pageable paginacao) {
        return controladoraRepository
                .findAll(paginacao)
                .map(ControladoraExibicaoDto::new);
    }

    public ControladoraExibicaoDto atualizar(Controladora controladora) {
        Optional<Controladora> controladoraOptional = controladoraRepository.findById(controladora.getCdControladora());
        if (controladoraOptional.isPresent()) {
            return new ControladoraExibicaoDto(controladoraRepository.save(controladora));
        } else {
            throw new RegistroNaoEncontradoException("Controladora não existe!");
        }
    }

    public void excluir(Long id) {
        Optional<Controladora> controladoraOptional = controladoraRepository.findById(id);
        if (controladoraOptional.isPresent()) {
            controladoraRepository.delete(controladoraOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Controladora não existe!");
        }
    }
}
