package br.com.fiap.semaforos.controller;

import br.com.fiap.semaforos.dto.UsuarioCadastroDto;
import br.com.fiap.semaforos.dto.UsuarioExibicaoDto;
import br.com.fiap.semaforos.model.Usuario;
import br.com.fiap.semaforos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto gravar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return service.gravar(usuarioCadastroDto);
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibicaoDto> listarTodosOsUsuarios(Pageable paginacao) {
        return service.listarTodosOsUsuarios(paginacao);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto atualizar(@RequestBody Usuario usuario) {
        //return service.atualizar(usuario);
        return service.atualizar(usuario);
    }

    @GetMapping("/usuarios/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarUsuarioPeloNome(@PathVariable String nome) {
        return service.buscarUsuarioPeloNome(nome);
    }

    @GetMapping(value = "/usuarios", params = "nome")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarUsuarioPorNome(@RequestParam String nome) {
        return service.buscarUsuarioPeloNome(nome);
    }

}
