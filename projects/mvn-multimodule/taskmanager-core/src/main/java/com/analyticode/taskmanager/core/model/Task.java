package com.analyticode.taskmanager.core.model;

public class Task {

    private String title;

    public Task(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task(" + title + ")";
    }

}
