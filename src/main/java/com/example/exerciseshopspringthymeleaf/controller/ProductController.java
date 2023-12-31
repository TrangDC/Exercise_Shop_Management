package com.example.exerciseshopspringthymeleaf.controller;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import com.example.exerciseshopspringthymeleaf.service.ICategoryService;
import com.example.exerciseshopspringthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

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

}
