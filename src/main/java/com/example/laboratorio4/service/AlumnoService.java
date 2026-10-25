package com.example.laboratorio4.service;

import com.example.laboratorio4.model.Alumno;
import com.example.laboratorio4.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> actualizar(Long id, Alumno alumnoDetalles) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombres(alumnoDetalles.getNombres());
            alumno.setCarrera(alumnoDetalles.getCarrera());
            alumno.setCiclo(alumnoDetalles.getCiclo());
            alumno.setPromedio(alumnoDetalles.getPromedio());
            return alumnoRepository.save(alumno);
        });
    }

    public boolean eliminar(Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}