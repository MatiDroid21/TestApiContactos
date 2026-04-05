package com.example.contactos.contacto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.contactos.contacto.model.Contacto;
import com.example.contactos.contacto.repository.ContactoRepository;

@Service
public class ContactoService {

    private final ContactoRepository repo;

    public ContactoService(ContactoRepository repo) {
        this.repo = repo;
    }

    public List<Contacto> listarTodos() {
        return repo.findAll();
    }

    public Optional<Contacto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public List<Contacto> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    public Contacto guardar(Contacto contacto) {
        if (repo.existsByEmail(contacto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un contacto con ese email");
        }
        return repo.save(contacto);
    }

    public Contacto actualizar(Long id, Contacto datos) {
        Contacto existente = repo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Contacto no encontrado: " + id));
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setTelefono(datos.getTelefono());
        existente.setEmpresa(datos.getEmpresa());
        return repo.save(existente);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Contacto no encontrado: " + id);
        }
        repo.deleteById(id);
    }
}

