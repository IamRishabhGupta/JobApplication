package com.projects.firstjobapp.job.impl;

import com.projects.firstjobapp.job.Job;
import com.projects.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class JobServiceImpl implements JobService {


    private List<Job> jobs=new ArrayList<>();
    int id=1;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(id);
        id++;
        jobs.add(job);
    }


}
