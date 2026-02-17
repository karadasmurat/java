package com.analyticode.taskmanager.app;

import com.analyticode.taskmanager.core.model.Task;
import com.analyticode.taskmanager.core.util.Helper;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello, modular app!");

        Task task = new Task("groceries");
        System.out.println(task);

        Helper.info();

    }

}
