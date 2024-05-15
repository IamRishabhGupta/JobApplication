package com.projects.firstjobapp.job;

import java.util.List;

public interface JobService {


    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(int id);

    boolean deleteJobById(int id);

    boolean updateJobById(int id,Job job);
}
