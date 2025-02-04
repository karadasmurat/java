package com.example.demo.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class JobService implements ServiceCRUD<Job> {

    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String create(Job job) {
        jobs.add(job);
        return "Job added successfully";
    }

    public ResponseEntity<Job> findById(Long id) {

        Optional<Job> job = jobs.stream().filter(j -> j.id() == id).findFirst();

        // return job.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        // : new ResponseEntity<>(job.get(), HttpStatus.OK);

        return ResponseEntity.of(job);

    }

    @Override
    public boolean deleteById(Long id) {

        return jobs.removeIf(job -> job.id() == id);
    }

}
