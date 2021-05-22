package me.cd.dojos.services;

import org.springframework.stereotype.Service;

import me.cd.dojos.models.Ninja;
import me.cd.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public Ninja add(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
