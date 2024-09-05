package org.bedu.todo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bedu.todo.model.Todo;
import org.springframework.stereotype.Repository;

// Repository es una clase que provee de método que manipulan datos
// y estos datos pueden estar almacenados en memoria (lista, arreglo, etc), en un archivo,
// en una base de datos o en la nube.

@Repository
public class TodoRepository {
    
    private List<Todo> data = new ArrayList<>();
    private int currentId = 0;

    public int size() {
        return data.size();
    }

    public List<Todo> findAll() {
        return data;
    }

    public void save(Todo todo) {
        todo.setId(++currentId);
        todo.setCompleted(false);
        
        data.add(todo);
    }
}
