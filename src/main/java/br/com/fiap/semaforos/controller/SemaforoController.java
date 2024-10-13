package br.com.fiap.semaforos.controller;

import br.com.fiap.semaforos.dto.SemaforoCadastroDto;
import br.com.fiap.semaforos.dto.SemaforoExibicaoDto;
import br.com.fiap.semaforos.model.Semaforo;
import br.com.fiap.semaforos.service.SemaforoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SemaforoController {

    @Autowired
    private SemaforoService service;

    @PostMapping("/semaforos")
    @ResponseStatus(HttpStatus.CREATED)
    public SemaforoExibicaoDto gravar(@RequestBody @Valid SemaforoCadastroDto semaforoCadastroDto) {
        return service.gravar(semaforoCadastroDto);
    }

    @GetMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public Page<SemaforoExibicaoDto> listarTodosOsSemaforos(Pageable paginacao) {
        return service.listarTodosOsSemaforos(paginacao);
    }

    @DeleteMapping("/semaforos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public SemaforoExibicaoDto atualizar(@RequestBody Semaforo semaforo) {
        return service.atualizar(semaforo);
    }

}
