package com.beer_purchase.Beer_Purchase_Service.api;

import com.beer_purchase.Beer_Purchase_Service.model.SoldBeer;
import com.beer_purchase.Beer_Purchase_Service.beerPurchase.BeerPurchaseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/beersale")
@AllArgsConstructor
@NoArgsConstructor
public class BeerPurchaseController {
    @Autowired
    BeerPurchaseService beerPurchaseService;

    @PostMapping()
    public SoldBeer addSale(@RequestBody SoldBeer beer) {
        return beerPurchaseService.addSale(beer);
    }

    @GetMapping()
    public List<SoldBeer> getAll() {
        return beerPurchaseService.getAll();
    }

    @GetMapping("/{sale_id}")
    public SoldBeer getById(@PathVariable(value = "sale_id") UUID id) {
        return beerPurchaseService.getById(id);
    }

    @DeleteMapping("/{sale_id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "sale_id") UUID id) {
        beerPurchaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}