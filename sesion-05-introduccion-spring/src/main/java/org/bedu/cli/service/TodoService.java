package org.bedu.cli.service;

import java.util.ArrayList;
import org.bedu.cli.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    private ArrayList<Todo> todos = new ArrayList<>();
    private int currentId = 0;

    public void save(String description) {
        Todo todo = new Todo();

        todo.setDescription(description);
        todo.setCompleted(false);
        todo.setId(++currentId);

        todos.add(todo);
    }

    public int size() {
        return todos.size();
    }

    public Todo get(int index) {
        return todos.get(index);
    }
}
