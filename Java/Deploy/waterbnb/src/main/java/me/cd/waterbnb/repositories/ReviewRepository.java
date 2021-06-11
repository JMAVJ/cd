package me.cd.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.waterbnb.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    
}
