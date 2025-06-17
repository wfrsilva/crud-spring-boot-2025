package dev.wfrsilva.crud_spring_boot_2025.business;

import org.springframework.stereotype.Service;

import dev.wfrsilva.crud_spring_boot_2025.infrastructure.entity.Usuario;
import dev.wfrsilva.crud_spring_boot_2025.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }//constructor

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }//salvarUsuario

    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não encontrado")
        );

    }//buscarUsuarioPorEmail

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }//deletaUsuarioPorEmail

    public void atualizarUsuarioPorEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
        .email(email)
        .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
        .id(usuarioEntity.getId())
        .build();

        repository.saveAndFlush(usuarioAtualizado);

    }//atualizarUsuarioPorEmail

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
            ()-> new RuntimeException("Usuario nao encontrado")
        );

        Usuario  usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() != null? usuario.getEmail() : usuarioEntity.getEmail())
        .nome(usuario.getNome() != null? usuario.getNome() : usuarioEntity.getNome())
        .id(usuarioEntity.getId())
        .build();

        repository.saveAndFlush(usuarioAtualizado);

    }//atualizarUsuarioPorId


}//UsuarioService
