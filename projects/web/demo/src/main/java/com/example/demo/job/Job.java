package com.example.demo.job;

public record Job(Long id, String title, String description, double minSalary, double maxSalary, String location) {

}
