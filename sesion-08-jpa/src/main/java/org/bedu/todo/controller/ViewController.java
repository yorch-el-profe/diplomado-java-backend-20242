package org.bedu.todo.controller;

import java.util.List;

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
        List<Todo> todos = repository.findAll();
        
        // Se envía una lista de todos las tareas
        // del repositorio
        m.addAttribute("todos", todos);

        return "index.html";
    }

    @GetMapping("crear")
    public String create(Model m) {
        Todo todo = new Todo();

        // Se envía un objeto vacío al HTML
        // para ser llenado por él
        m.addAttribute("todo", todo);

        return "create.html";
    }
}
