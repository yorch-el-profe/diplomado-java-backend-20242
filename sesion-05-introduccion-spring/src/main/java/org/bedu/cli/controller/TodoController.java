package org.bedu.cli.controller;

import java.util.Scanner;
import org.bedu.cli.model.Todo;
import org.bedu.cli.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Componente: Es una clase que puede reutilizarse en otras clases dentro de Spring

@Component
public class TodoController {

    @Autowired
    private Scanner sc;
    
    @Autowired
    private TodoService service;

    public void menu() {
        int option = 0;

        while (option != 5) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Ver las tareas (" + service.size() + ")");
            System.out.println("2. Agregar una nueva tarea");
            System.out.println("3. Marcar una tarea como completado");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Salir");

            option = sc.nextInt();
            sc.nextLine(); // Evitar que Scanner haga cosas extrañas (siempre y cuando, la captura no sea
                           // un String)

            switch (option) {
                case 1:
                    showTodo();
                    break;

                case 2:
                    addTodo();
                    break;

                case 3:
                    completeTodo();
                    break;

                case 4:
                    deleteTodo();
                    break;

                case 5:
                break;

                default:
                    System.out.println("ERROR: ELIGE UNA OPCIÓN VÁLIDA.");
            }
        }
    }

    public void showTodo() {
        System.out.println("\nLista de tareas:");

        for (int i = 0; i < service.size(); i++) {
            Todo todo = service.get(i);
            System.out.println("#" + todo.getId() + " - " + todo.getDescription() + (todo.isCompleted() ? "(COMPLETADO)" : ""));
        }
    }

    public void addTodo() {
        System.out.println("\n¿Cuál es tu tarea pendiente?");

        String description = sc.nextLine();

        service.save(description);
    }

    public void completeTodo() {

    }

    public void deleteTodo() {

    }
}
