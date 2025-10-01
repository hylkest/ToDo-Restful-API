package com.todoapp.todolist;

import com.todoapp.todolist.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    void testAddTask() {
        Task task = new Task(null, "Test taak", false);
        Task saved = taskService.addTask(task);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Test taak");
        assertThat(saved.isCompleted()).isFalse();
    }
}
