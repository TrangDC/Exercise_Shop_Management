package com.example.exerciseshopspringthymeleaf.controller;

import com.example.exerciseshopspringthymeleaf.model.Cart;
import com.example.exerciseshopspringthymeleaf.model.Product;
import com.example.exerciseshopspringthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/api/shopping-cart")
public class CartController {

    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error-404";
        } else {
            cart.deleteProductFromCart(id);
            return "redirect:/api/shopping-cart";
        }
    }
}
