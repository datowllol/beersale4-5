package com.beer_purchase.Beer_Purchase_Service.model;


import com.beer_purchase.Beer_Purchase_Service.SoldBeerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@AllArgsConstructor
public final class SoldBeer {
    @Id
    private UUID soldBeerId;

    @Column
    private int moneyGain;
    private String beerType;
    private UUID visitorsId;

    public SoldBeer() {
        soldBeerId = UUID.randomUUID();
    }

    public SoldBeer(int moneyGain, String beerType) {
        soldBeerId = UUID.randomUUID();
        this.moneyGain = moneyGain;
        this.beerType = beerType;
    }

    public SoldBeerRequest toSoldBeerResponse() {
        return SoldBeerRequest.newBuilder().
                setSoldBeerId(soldBeerId.toString()).
                setMoneyGain(moneyGain).
                setBeerType(beerType).
                setVisitorsId(visitorsId.toString()).
                build();
    }

    public static SoldBeer fromSoldBeerRequest(SoldBeerRequest soldBeerResponse) {
        return new SoldBeer( UUID.fromString(soldBeerResponse.getSoldBeerId()),
                soldBeerResponse.getMoneyGain(),
                soldBeerResponse.getBeerType(),
                UUID.fromString(soldBeerResponse.getVisitorsId()));
    }
}
