// "com.todoapp.todolist" staat gelijk aan de map naam
package com.todoapp.todolist;

// Springboot packages importeren
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// @RestController geeft json data terug via HTTP
@RestController
// @ReuestMapping geeft aan wat het basisadres van de controller is.
// Dus als iemand het adres bezoekt met /api/tasks komt hij hierin
@RequestMapping("/api/tasks")
public class TaskController {
//    Get mapping zorgt ervoor dat deze methode wordt aangeroepen bij een GET verzoek
    @GetMapping
//    Hier een functie die een lijst met strings teruggeeft
    public List<String> getTasks() {
        return List.of(
                "Takenlijst maken",
                "Spring boot leren",
                "Rest API bouwen"
        );
    }
}
