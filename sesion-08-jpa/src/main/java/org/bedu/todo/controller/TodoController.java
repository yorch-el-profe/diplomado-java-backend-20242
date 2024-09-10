package org.bedu.todo.controller;

import org.bedu.todo.model.Todo;
import org.bedu.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository repository;
    
    // @ModelAttribute me ayuda a extraer un objeto de la petición.
    @PostMapping("guardar")
    public String save(@ModelAttribute("todo") Todo t) {

        // Guardar el objeto todo
        repository.save(t);

        // Redirigir a la vista principal
        return "redirect:/";
    }

    @PostMapping("completar")
    public String complete(@ModelAttribute("id") int id) {

        repository.complete(id);

        return "redirect:/";
    }
}
