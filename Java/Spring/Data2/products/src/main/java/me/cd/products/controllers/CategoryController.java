package me.cd.products.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.products.models.Category;
import me.cd.products.services.CategoryService;
import me.cd.products.services.ProductService;


@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCategoryView() {
        return "newCategory.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name) {
        Category category = categoryService.add(name);
        return "redirect:/categories/" + category.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String category(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        model.addAttribute("products", productService.getAllExceptInCategory(category));
        return "category.jsp";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.PUT)
    public String addProduct(@RequestParam("category_id") Long categoryId, @RequestParam("product_id") Long productId) {
        Category category = categoryService.addProduct(categoryId, productId);
        return "redirect:/categories/" + category.getId();
    }
}
