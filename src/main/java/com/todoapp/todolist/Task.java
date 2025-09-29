package com.todoapp.todolist;

public class Task {
//    "Long" is een type voor "Lange getallen"
//    "Private" betekent dat ik het niet kan benaderen buiten de class
    private Long id;
    private String title;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Task(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

}
