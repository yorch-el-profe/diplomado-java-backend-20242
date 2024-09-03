package org.bedu.todo.controller;

import org.bedu.todo.model.Todo;
import org.bedu.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private TodoRepository repository;
    
    @GetMapping
    public String index(Model m) {
        String message = "Tareas pendientes: " + repository.size();

        m.addAttribute("message", message);

        return "index.html";
    }

    @GetMapping("crear")
    public String create(Model m) {

        // Se envía un objeto vacío al HTML
        // para ser llenado por él
        m.addAttribute("todo", new Todo());

        return "create.html";
    }
}
