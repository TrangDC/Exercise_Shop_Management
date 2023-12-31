package com.example.exerciseshopspringthymeleaf.controller;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import com.example.exerciseshopspringthymeleaf.service.ICategoryService;
import com.example.exerciseshopspringthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> listCategories() {
        return iCategoryService.findAll();
    }

    @GetMapping()
    public ModelAndView listProductsActive() {
        ModelAndView modelAndView = new ModelAndView("/products/list");
        Iterable<Product> products = iProductService.findAll();
        ArrayList<Product> productsTrue = new ArrayList<Product>();

        for (Product product : products) {
            if (product.isActive()) {
                productsTrue.add(product);
            }
        }
        modelAndView.addObject("products", productsTrue);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("/products/add");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(@Validated @ModelAttribute Product product,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/products/add");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            iProductService.save(product);
            ModelAndView modelAndView = new ModelAndView("/products/list");
            Iterable<Product> products = iProductService.findAll();
            modelAndView.addObject("products", products);
            return modelAndView;
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/products/update");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@Validated @ModelAttribute Product product,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "/products/update";
        } else {
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("message", "Update Successfully");
            return "redirect:/api/products";
        }
    }
}
