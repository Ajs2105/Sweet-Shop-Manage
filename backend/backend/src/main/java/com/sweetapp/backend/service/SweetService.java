package com.sweetapp.backend.service;

import com.sweetapp.backend.entity.Sweet;
import com.sweetapp.backend.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SweetService {

    private final SweetRepository repo;

    public SweetService(SweetRepository repo) {
        this.repo = repo;
    }

    public Sweet addSweet(Sweet sweet) {
        return repo.save(sweet);
    }

    public List<Sweet> getAll() {
        return repo.findAll();
    }

    public Sweet update(Long id, Sweet sweet) {
        Sweet s = repo.findById(id).orElseThrow();
        s.setName(sweet.getName());
        s.setCategory(sweet.getCategory());
        s.setPrice(sweet.getPrice());
        s.setQuantity(sweet.getQuantity());
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Sweet purchase(Long id) {
        Sweet s = repo.findById(id).orElseThrow();
        if (s.getQuantity() <= 0) {
            throw new RuntimeException("Out of stock");
        }
        s.setQuantity(s.getQuantity() - 1);
        return repo.save(s);
    }

    public Sweet restock(Long id, int qty) {
        Sweet s = repo.findById(id).orElseThrow();
        s.setQuantity(s.getQuantity() + qty);
        return repo.save(s);
    }

    public List<Sweet> search(String name, String category, Double min, Double max) {
        List<Sweet> results = repo.findAll();
        
        if (name != null && !name.isEmpty()) {
            results = results.stream()
                    .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        
        if (category != null && !category.isEmpty()) {
            results = results.stream()
                    .filter(s -> s.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }
        
        if (min != null) {
            results = results.stream()
                    .filter(s -> s.getPrice() >= min)
                    .collect(Collectors.toList());
        }
        
        if (max != null) {
            results = results.stream()
                    .filter(s -> s.getPrice() <= max)
                    .collect(Collectors.toList());
        }
        
        return results;
    }
}
