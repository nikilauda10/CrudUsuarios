package com.example.u3holamundo.service;

import com.example.u3holamundo.model.Tarea;
import com.example.u3holamundo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Transactional(readOnly = true)
    public List<Tarea> consultarTareas(){
        return tareaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Tarea> buscarPorId(Long id){
        return tareaRepository.findById(id);
    }

    public Tarea crearTarea(Tarea unaTarea){
        return tareaRepository.save(unaTarea);
    }

    @Transactional
    public Tarea actualizarTarea (Long id, Tarea unaTarea){
        Optional<Tarea> optTarea = tareaRepository.findById(id);
        if(optTarea.isPresent()){
            Tarea tarea2= optTarea.get();
            tarea2.setTitulo(unaTarea.getTitulo());
            tarea2.setCompletada(unaTarea.getCompletada());
            return tareaRepository.save(tarea2);
        }
        return null;

    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}

