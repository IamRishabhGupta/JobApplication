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

    @Override
    public Job getJobById(int id) {
        for(Job job:jobs)
        {
            if(job.getId()==id)
            {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(int id) {


        boolean flag=false;
        for(Job job:jobs)
        {
            if(job.getId()==id)
            {
                jobs.remove(job);
                flag=true;
            }
        }

        return flag;

    }

    @Override
    public boolean updateJobById(int id,Job updatedJob) {
        boolean flag=false;
        for(Job job:jobs)
        {
            if(job.getId()==id)
            {
                flag=true;
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
            }
        }

        return flag;
    }


}
