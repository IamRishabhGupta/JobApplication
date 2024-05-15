package com.projects.firstjobapp.job;

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
    public List<Job> findAll()
    {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job)
    {
        jobService.createJob(job);
        return "Job added Successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable int id)
    {
        Job job=jobService.getJobById(id);
        if(job!=null)
        return job;

        Job temp=new Job(1,"Test","Record not found","0","0","mars");
        return temp;

    }
}
