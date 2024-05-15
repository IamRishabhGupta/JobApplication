package com.projects.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class JobController {


        private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll()
    {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added Successfully",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id)
    {


        Job job=jobService.getJobById(id);
        if(job!=null)
        return new ResponseEntity<>(job,HttpStatus.OK);

//        Job temp=new Job(1,"Test","Record not found","0","0","mars");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/jobs/delete/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable int id)
    {
       boolean checkIfExists=jobService.deleteJobById(id);

       if(checkIfExists==true)
       {
           return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
       }

        return new ResponseEntity<>("Job with given job ID does not exists",HttpStatus.NOT_FOUND);
    }


    @PutMapping("/jobs/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Job updatedJob)
    {
        boolean updated =jobService.updateJobById(id,updatedJob);


        if(updated)
        {
            return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with given job ID does not exists",HttpStatus.NOT_FOUND);


    }
}
