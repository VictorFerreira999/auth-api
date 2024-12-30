package io.victorferreira.auth_api.services.imlp;

import io.victorferreira.auth_api.dtos.UsuarioDto;
import io.victorferreira.auth_api.models.Usuario;
import io.victorferreira.auth_api.repositories.UsuarioRepository;
import io.victorferreira.auth_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if(usarioJaExiste != null) {
            throw new RuntimeException("Usuario já exite");
        }

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), usuarioDto.senha());
        Usuario novoUsuario = usuarioRepository.save(entity);
        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha());
    }
}
