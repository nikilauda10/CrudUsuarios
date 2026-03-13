package com.example.u3holamundo.controller;

import com.example.u3holamundo.model.Tarea;
import com.example.u3holamundo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.consultarTareas();
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}
