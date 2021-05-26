package me.cd.products.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.products.models.Product;
import me.cd.products.services.CategoryService;
import me.cd.products.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProductView(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product) {        
        Product newProduct = productService.add(product);
        return "redirect:/products/" + newProduct.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String product(@PathVariable("id") Long id ,Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllExceptContainingProduct(product));
        return "product.jsp";
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.PUT)
    public String addCategory(@RequestParam("product_id") Long productId, @RequestParam("category_id") Long categoryId) {
        Product product = productService.addCategory(productId, categoryId);
        return "redirect:/products/" + product.getId();
    }
}
