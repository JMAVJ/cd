package me.cd.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.products.models.Category;
import me.cd.products.models.Product;
import me.cd.products.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product addCategory(Long productId, Long categoryId) {
        Product product = getById(productId);
        Category category = categoryService.getById(categoryId);
        List<Category> productCategories = product.getCategories();
        productCategories.add(category);
        product.setCategories(productCategories);
        return productRepository.save(product);
    }

    public List<Product> getAllExceptInCategory(Category category) {
        return productRepository.findByCategoriesNotContaining(category);
    }
}
