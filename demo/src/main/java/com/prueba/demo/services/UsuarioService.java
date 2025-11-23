package com.prueba.demo.services;

import com.prueba.demo.document.Usuario;
import com.prueba.demo.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usurep;

    public UsuarioService(UsuarioRepository usurep) {
        this.usurep = usurep;
    }

    public List<Usuario> listar() {
        return usurep.findAll();
    }

    public Usuario autenticarUsuario(String username, String password) {
        return usurep.findByUsername(username)
                .map(u -> u.getPassword().equals(password) ? u : null)
                .orElse(null);
    }

    // 🔹 Cambiado a retornar Usuario
    public Usuario guardar(Usuario usuario){
        return usurep.save(usuario);
    }

    public void eliminar(String id) {
        usurep.deleteById(id);
    }

    public Usuario autenticarUsuarioPorId(String id) {
        return usurep.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }
    public Usuario obtenerUsuarioAutenticado() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            return null;
        }

        Object principal = auth.getPrincipal();
        String username;

        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        return usurep.findByUsername(username).orElse(null);
    }
}
