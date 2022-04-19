package bcp.bootcamp.paymentservicesfavorites.services;

import bcp.bootcamp.paymentservicesfavorites.entities.Favorite;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavoriteService {
    Flux<Favorite> findById(String userId);
}
