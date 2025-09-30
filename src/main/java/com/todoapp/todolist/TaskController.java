// "com.todoapp.todolist" staat gelijk aan de map naam
package com.todoapp.todolist;

// Springboot packages importeren
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// @RestController geeft json data terug via HTTP
@RestController
// @ReuestMapping geeft aan wat het basisadres van de controller is.
// Dus als iemand het adres bezoekt met /api/tasks komt hij hierin
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
//        Get mapping zorgt ervoor dat deze methode wordt aangeroepen bij een GET verzoek
    @GetMapping
//    Hier een functie die een lijst met strings teruggeeft
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

//    Bij een POST verzoek naar /api/tasks wordt dit uitgevoerd
    @PostMapping
//    @RequestBody: vertelt Spring Boot dat de JSON-inhoud van het verzoek moet
//    worden omgezet naar een Task object
    public Task addTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }
//  @DeleteMapping("/{id}"): deze methode wordt aangeroepen als iemand
//  een DELETE-request doet naar /api/tasks/1
//    @PathVariable Long id: het stukje {id} uit de URL wordt gekoppeld aan de parameter id
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }
}
