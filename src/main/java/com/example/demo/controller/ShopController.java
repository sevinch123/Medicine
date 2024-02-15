package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class ShopController {

    private final ShopService service;

    @GetMapping()
    public String listPage(Model model, Pageable pageable) {
        model.addAttribute("shops", service.getAll(pageable));
        return "/admin/data/shop/list";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("shop", new Shop());
        return "/admin/data/shop/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Shop shop) {
        service.save(shop);
        return "redirect:/admin/data/shop";
    }

    @GetMapping("/edit")
    public String editPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("shop", service.getById(id));
        return "/admin/data/shop/add";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Shop shop) {
        service.update(shop);
        return "redirect:/admin/data/shop";
    }

    @GetMapping("delete/{id}")
    public String deleteShop(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (RuntimeException e) {
            Shop shop = service.getById(id);
            shop.setIsActive(false);
            service.update(shop);
        }
        return "redirect:/admin/data/shop";
    }

}
