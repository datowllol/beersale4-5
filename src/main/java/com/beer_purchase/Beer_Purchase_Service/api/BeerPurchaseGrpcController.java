package com.beer_purchase.Beer_Purchase_Service.api;


import com.beer_purchase.Beer_Purchase_Service.*;
import com.beer_purchase.Beer_Purchase_Service.beerPurchase.BeerPurchaseService;
import com.beer_purchase.Beer_Purchase_Service.model.SoldBeer;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@GRpcService
public class BeerPurchaseGrpcController extends BeerPurchaseServiceGrpc.BeerPurchaseServiceImplBase {
    @Autowired
    private BeerPurchaseService beerPurchaseService;

    @Override
    public void all(AllSoldBeerRequest request, StreamObserver<AllSoldBeerResponse> responseObserver) {
        List<SoldBeer> soldBeers = beerPurchaseService.getAll();
        List<SoldBeerRequest> convertedSoldBeer = soldBeers.stream().
                map(SoldBeer::toSoldBeerResponse).
                collect(Collectors.toList());
        AllSoldBeerResponse response = AllSoldBeerResponse.newBuilder().
                addAllSoldBeer(convertedSoldBeer).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(SoldBeerRequest request, StreamObserver<SoldBeerRequest> responseObserver) {
        SoldBeer soldBeer = beerPurchaseService.addSale(SoldBeer.fromSoldBeerRequest(request));
        responseObserver.onNext(soldBeer.toSoldBeerResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(SoldBeerRequestId request, StreamObserver<SoldBeerRequest> responseObserver) {
        SoldBeer soldBeer = beerPurchaseService.getById(UUID.fromString(request.getId()));
        responseObserver.onNext(soldBeer.toSoldBeerResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteSoldBeerRequest request, StreamObserver<DeleteSoldBeerResponse> responseObserver) {
        beerPurchaseService.deleteById(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteSoldBeerResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

}
