package com.beer_purchase.Beer_Purchase_Service.rabbitmq;


import com.beer_purchase.Beer_Purchase_Service.BeerPurchase;
import com.beer_purchase.Beer_Purchase_Service.beerPurchase.BeerPurchaseService;
import com.beer_purchase.Beer_Purchase_Service.model.SoldBeer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    BeerPurchaseService beerPurchaseService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(SoldBeer soldBeer) {
        beerPurchaseService.addSale(soldBeer);
    }
}