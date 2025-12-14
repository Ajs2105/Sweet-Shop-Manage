package com.sweetapp.backend.controller;

import com.sweetapp.backend.entity.Sweet;
import com.sweetapp.backend.service.SweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService service;

    public SweetController(SweetService service) {
        this.service = service;
    }

    @PostMapping
    public Sweet add(@RequestBody Sweet sweet) {
        return service.addSweet(sweet);
    }

    @GetMapping
    public List<Sweet> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Sweet> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return service.search(name, category, minPrice, maxPrice);
    }

    @PutMapping("/{id}")
    public Sweet update(@PathVariable Long id, @RequestBody Sweet sweet) {
        return service.update(id, sweet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{id}/purchase")
    public Sweet purchase(@PathVariable Long id) {
        return service.purchase(id);
    }

    @PostMapping("/{id}/restock")
    public Sweet restock(@PathVariable Long id, @RequestParam int qty) {
        return service.restock(id, qty);
    }
}
