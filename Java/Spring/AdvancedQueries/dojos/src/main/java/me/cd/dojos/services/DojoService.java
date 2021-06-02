package me.cd.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.dojos.models.Dojo;
import me.cd.dojos.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAll() {
        return dojoRepository.findAll();
    }

    public Dojo getById(Long id) {
        Optional<Dojo> dojo = dojoRepository.findById(id);
        if (!dojo.isPresent()) {
            return null;
        }
        return dojo.get();
    }

    public Dojo add(String name) {
        Dojo dojo = new Dojo(name);
        return dojoRepository.save(dojo);
    }
}
