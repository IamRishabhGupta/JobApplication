package com.projects.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;


//Spring Data JPA's JpaRepository interface offers several methods out-of-the-box, including:
//CRUD Operations: Methods like save(entity), findById(id), findAll(), delete(entity) etc., for basic CRUD operations.
//Query Methods: Methods like findBy..., deleteBy...,
// which are derived from method names and automatically implemented based on the entity's properties.
public interface JobRepository extends JpaRepository<Job, Long> {
}
