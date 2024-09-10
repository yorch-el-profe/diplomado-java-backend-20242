package org.bedu.todo.repository;


import org.bedu.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

// Repository es una clase que provee de métodos que manipulan datos
// y estos datos pueden estar almacenados en memoria (lista, arreglo, etc), en un archivo,
// en una base de datos o en la nube.

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    // Métodos ya existentes en JPARepository
    // findAll() -> Regresa todos los registros de la tabla
    // findById(int id) -> Regresa el registro con el id indicado
    // save(Todo todo) -> Crear un nuevo registro en la tabla / actualiza
    // deleteById(int id) -> Elimina un registro por id


    // JPQL -> Java Persistence Query Language
    // SQL: UPDATE todos SET completed = TRUE WHERE id = :id
    // JPQL: UPDATE Todo t SET t.completed = true WHERE t.id = :id
    @Transactional
    @Modifying
    @Query("UPDATE Todo t SET t.completed = true WHERE t.id = :x")
    void complete(@Param("x") int id);
}
