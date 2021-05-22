package me.cd.dojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.dojos.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
    
}
