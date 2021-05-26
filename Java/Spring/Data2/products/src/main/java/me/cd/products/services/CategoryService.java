package me.cd.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.products.models.Category;
import me.cd.products.models.Product;
import me.cd.products.repositories.CategoryRepository;
import me.cd.products.repositories.ProductRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    } 

    public Category add(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    public List<Category> getAllExceptContainingProduct(Product product) {
        return categoryRepository.findByProductsNotContaining(product);
    }

    public Category addProduct(Long categoryId, Long productId) {
        Category category = getById(categoryId);
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.get();
        List<Product> categoryProducts = category.getProducts();
        categoryProducts.add(product);
        category.setProducts(categoryProducts);
        return categoryRepository.save(category);
    }
}
