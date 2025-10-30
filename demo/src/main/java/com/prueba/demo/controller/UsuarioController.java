package com.prueba.demo.controller;

import com.prueba.demo.entity.Usuario;
import com.prueba.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public void guardar(@RequestBody Usuario usuario) {
        usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
