package com.prueba.demo.services;

import com.prueba.demo.entity.Cliente;
import com.prueba.demo.entity.Usuario;
import com.prueba.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usurep;

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(new Usuario("admin", "admin123", "ADMINISTRADOR"));
        usuarios.add(new Usuario("vendedor", "vendedor123", "VENDEDOR"));
    }

    public Usuario autenticarUsuario(String username, String password) {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getUsername());
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public void guardar(Usuario usuario){
        usurep.save(usuario);
    }
    public List<Usuario> listar() {
        return usurep.findAll();
    }

    public void eliminar(Long id) {
        usurep.deleteById(id);
    }

}
