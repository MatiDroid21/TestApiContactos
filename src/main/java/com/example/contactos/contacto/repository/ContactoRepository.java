package com.example.contactos.contacto.repository;
import com.example.contactos.contacto.model.Contacto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByEmail(String email);
}
