package com.nishanth.jobtracker;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public JobApplication saveApplication(JobApplication application) {
        return repository.save(application);
    }
    
    public JobApplication getApplicationById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public JobApplication updateApplication(Long id, JobApplication updatedApplication) {
        JobApplication existingApplication = repository.findById(id).orElse(null);

        if (existingApplication == null) {
            return null;
        }

        existingApplication.setCompanyName(updatedApplication.getCompanyName());
        existingApplication.setJobRole(updatedApplication.getJobRole());
        existingApplication.setStatus(updatedApplication.getStatus());
        existingApplication.setAppliedDate(updatedApplication.getAppliedDate());
        existingApplication.setJobLink(updatedApplication.getJobLink());
        existingApplication.setNotes(updatedApplication.getNotes());

        return repository.save(existingApplication);
    }
    
    public boolean deleteApplication(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}