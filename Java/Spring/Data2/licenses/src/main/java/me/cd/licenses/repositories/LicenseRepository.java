package me.cd.licenses.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.licenses.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    
}
