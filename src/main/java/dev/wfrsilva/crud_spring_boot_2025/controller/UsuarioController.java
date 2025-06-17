package dev.wfrsilva.crud_spring_boot_2025.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.wfrsilva.crud_spring_boot_2025.business.UsuarioService;
import dev.wfrsilva.crud_spring_boot_2025.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        //Recomendato DTO, aqui nao usado para simplificar implantacao - https://youtu.be/yW7RrWfUeHE?list=PLVH4zxtGfwkPZfp2TGTI7yF0erKGBXozX&t=1785
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }//salvarUsuario


    @GetMapping
    public ResponseEntity <Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }//buscarUsuarioPorEmail
       

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }//deletarUsuarioPorEmail


    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId (@RequestParam Integer id, @RequestBody  Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }//atualizarUsuarioPorId

}//UsuarioController
