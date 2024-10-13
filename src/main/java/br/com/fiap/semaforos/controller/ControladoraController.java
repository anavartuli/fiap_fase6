package br.com.fiap.semaforos.controller;

import br.com.fiap.semaforos.dto.ControladoraCadastroDto;
import br.com.fiap.semaforos.dto.ControladoraExibicaoDto;
import br.com.fiap.semaforos.model.Controladora;
import br.com.fiap.semaforos.service.ControladoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControladoraController {

    @Autowired
    private ControladoraService service;

    @PostMapping("/controladora")
    @ResponseStatus(HttpStatus.CREATED)
    public ControladoraExibicaoDto gravar(@RequestBody @Valid ControladoraCadastroDto controladoraCadastroDto) {
        return service.gravar(controladoraCadastroDto);
    }

    @GetMapping("/controladora")
    @ResponseStatus(HttpStatus.OK)
    public Page<ControladoraExibicaoDto> listarTodasAsControladoras(Pageable paginacao) {
        return service.listarTodasAsControladoras(paginacao);
    }

    @DeleteMapping("/controladora/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/controladora")
    @ResponseStatus(HttpStatus.OK)
    public ControladoraExibicaoDto atualizar(@RequestBody Controladora controladora) {
        return service.atualizar(controladora);
    }

}
