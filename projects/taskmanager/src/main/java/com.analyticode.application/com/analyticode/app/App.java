package com.analyticode.app;

import com.analyticode.model.Task;
import com.analyticode.util.Helper;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello, modular app!");

        Task task = new Task("groceries");
        System.out.println(task);

        Helper.info();

    }

}
