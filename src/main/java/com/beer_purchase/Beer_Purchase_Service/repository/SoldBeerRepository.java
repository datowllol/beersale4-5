package com.beer_purchase.Beer_Purchase_Service.repository;

import com.beer_purchase.Beer_Purchase_Service.model.SoldBeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SoldBeerRepository extends JpaRepository<SoldBeer, UUID> {
}
