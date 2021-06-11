package me.cd.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.waterbnb.models.Pool;
import me.cd.waterbnb.models.Review;
import me.cd.waterbnb.models.User;
import me.cd.waterbnb.repositories.PoolRepository;
import me.cd.waterbnb.repositories.ReviewRepository;

@Service
public class PoolService {
    private final PoolRepository poolRepository;
    private final ReviewRepository reviewRepository;
    private final UserService userService;

    public PoolService(PoolRepository poolRepository, ReviewRepository reviewRepository, UserService userService) {
        this.poolRepository = poolRepository;
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }
    
    public Pool findById(Long id) {
        Optional<Pool> p = poolRepository.findById(id);
        return p.isPresent() ? p.get() : null;
    }

    public List<Pool> findByAddress(String address) {
        return poolRepository.findByAddressContaining(address);
    }

    public Pool add(Pool pool, Long userId) {
        User u = userService.findById(userId);
        pool.setHost(u);
        return poolRepository.save(pool);
    }

    public void addReview(User author, Pool pool, Review review) {
        review.setUser(author);
        review.setPool(pool);
        reviewRepository.save(review);
    }

    public Pool update(Pool pool, Pool newData) {
        pool.setDescription(newData.getDescription());
        pool.setSize(newData.getSize());
        pool.setPrice(newData.getPrice());
        return poolRepository.save(pool);
    }
}
