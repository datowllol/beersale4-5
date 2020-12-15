package com.beer_purchase.Beer_Purchase_Service.beerPurchase;

import com.beer_purchase.Beer_Purchase_Service.model.SoldBeer;

import java.util.List;
import java.util.UUID;

public interface InterfaceBeerPurchaseService {
    SoldBeer addSale(SoldBeer soldBeer);
    List<SoldBeer> getAll();
    public SoldBeer getById(UUID id);
    public void deleteById(UUID id);
}
