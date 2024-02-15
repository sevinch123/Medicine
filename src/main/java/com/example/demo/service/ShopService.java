package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    
    public Page<Shop> getAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    public Shop getById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Shop save(Shop shop) {
        if(shop.getShopId() != null)
            throw new RuntimeException("Id should be a null");

        if(shop.getIsActive() == null) shop.setIsActive(true);

        return shopRepository.save(shop);
    }

    public Shop update(Shop shop) {
        if(shop.getShopId() == null)
            throw new RuntimeException("Id shouldn't be null");

        return shopRepository.save(shop);
    }

    public void deleteById(Long id) {
        shopRepository.deleteById(id);
    }

    public void delete(Shop shop) {
        deleteById(shop.getShopId());
    }
}
