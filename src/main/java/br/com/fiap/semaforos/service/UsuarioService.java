package br.com.fiap.semaforos.service;

import br.com.fiap.semaforos.dto.UsuarioCadastroDto;
import br.com.fiap.semaforos.dto.UsuarioExibicaoDto;
import br.com.fiap.semaforos.exception.RegistroNaoEncontradoException;
import br.com.fiap.semaforos.model.Usuario;
import br.com.fiap.semaforos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioCadastroDto) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);
        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public UsuarioExibicaoDto buscarPeloId(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Usuario não existe");
        }
    }

    //Implementa paginação do JPA
    public Page<UsuarioExibicaoDto> listarTodosOsUsuarios(Pageable paginacao) {
        return usuarioRepository
                .findAll(paginacao)
                .map(UsuarioExibicaoDto::new);
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Usuario não existe");
        }
    }

    public UsuarioExibicaoDto atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
        } else {
            throw new RegistroNaoEncontradoException("Usuario não existe");
        }
    }

    public UsuarioExibicaoDto buscarUsuarioPeloNome(String nome) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarUsuarioPeloNome(nome);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new RegistroNaoEncontradoException("Usuario não existe!");
        }
    }

    
}
