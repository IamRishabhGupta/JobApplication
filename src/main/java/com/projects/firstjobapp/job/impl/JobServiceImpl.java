package com.projects.firstjobapp.job.impl;

import com.projects.firstjobapp.job.Job;
import com.projects.firstjobapp.job.JobRepository;
import com.projects.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {


//    private List<Job> jobs=new ArrayList<>();
    int id=1;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository)
    {
        this.jobRepository=jobRepository;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(id);
        id++;
        jobRepository.save(job);
//        jobs.add(job);
    }

    @Override
    public Job getJobById(int id) {
//        for(Job job)
//        {
//            if(job.getId()==id)
//            {
//                return job;
//            }
//        }

       return jobRepository.findById(id).orElse(null);

    }

    @Override
    public boolean deleteJobById(int id) {

//
        boolean flag=false;
        Job temp=jobRepository.findById(id).orElse(null);
        if(temp==null)
        {
            return false;
        }
        long idd=temp.getId();
        jobRepository.delete(temp);
        return true;


//        try{
//            jobRepository.deleteById(id);
//            return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }


//
    }

    @Override
    public boolean updateJobById(int id,Job updatedJob) {
        boolean flag=false;
        Optional<Job> jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Job job=jobOptional.get();
//            flag=true;
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setTitle(updatedJob.getTitle());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            return true;


        }
        else
        {
            return false;
        }
//


//        return flag;
    }


}
