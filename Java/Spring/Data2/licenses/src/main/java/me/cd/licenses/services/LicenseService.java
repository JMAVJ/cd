package me.cd.licenses.services;

import org.springframework.stereotype.Service;

import me.cd.licenses.models.License;
import me.cd.licenses.repositories.LicenseRepository;

@Service
public class LicenseService {
    public final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License add(License license) {
        license = licenseRepository.save(license);
        license.setNumber("00000" + license.getId());
        return licenseRepository.save(license);
    }
}
