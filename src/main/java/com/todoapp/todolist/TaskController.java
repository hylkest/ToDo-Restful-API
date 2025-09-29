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
    private List<Task> tasks = new ArrayList<>(List.of(
            new Task(1L, "Takenlijst maken", true),
            new Task(2L, "Spring boot leren", false),
            new Task(3L, "REST API bouwen", false)
    ));

//        Get mapping zorgt ervoor dat deze methode wordt aangeroepen bij een GET verzoek
    @GetMapping
//    Hier een functie die een lijst met strings teruggeeft
    public List<Task> getTasks() {
        return tasks;
    }

//    Bij een POST verzoek naar /api/tasks wordt dit uitgevoerd
    @PostMapping
//    @RequestBody: vertelt Spring Boot dat de JSON-inhoud van het verzoek moet
//    worden omgezet naar een Task object
    public void addTask(@RequestBody Task newTask) {
        tasks.add(newTask);
    }
//  @DeleteMapping("/{id}"): deze methode wordt aangeroepen als iemand
//  een DELETE-request doet naar /api/tasks/1
    @DeleteMapping("/{id}")
//    @PathVariable Long id: het stukje {id} uit de URL wordt gekoppeld aan de parameter id
    public void deleteTask(@PathVariable Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
