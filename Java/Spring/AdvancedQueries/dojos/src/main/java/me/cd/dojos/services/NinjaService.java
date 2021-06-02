package me.cd.dojos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.cd.dojos.models.Ninja;
import me.cd.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private static final int PAGE_SIZE = 2;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public Ninja add(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }


    public Page<Ninja> ninjaPage(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.ASC, "dojo.name"));
        Page<Ninja> page = ninjaRepository.findAll(pageRequest);
        return page;
    }
}
