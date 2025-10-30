package com.prueba.demo.data;

import com.prueba.demo.entity.Usuario;
import com.prueba.demo.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario(
                        "admin",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                );
                usuarioRepository.save(admin);
                System.out.println("Usuario ADMIN creado");
            }

            if (usuarioRepository.findByUsername("vendedor").isEmpty()) {
                Usuario vendedor = new Usuario(
                        "vendedor",
                        passwordEncoder.encode("vendedor123"),
                        "VENDEDOR"
                );
                usuarioRepository.save(vendedor);
                System.out.println("Usuario VENDEDOR creado");
            }
        };
    }
}
