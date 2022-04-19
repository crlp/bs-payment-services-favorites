package bcp.bootcamp.paymentservicesfavorites.handlers;

import bcp.bootcamp.paymentservicesfavorites.core.exceptions.FavoriteBaseException;
import bcp.bootcamp.paymentservicesfavorites.entities.Favorite;
import bcp.bootcamp.paymentservicesfavorites.services.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class FavoriteHandler {

    @Autowired
    private FavoriteService subscriberService;

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id").toLowerCase();
        return this.subscriberService.findById(id)
                .switchIfEmpty(Mono.error(new FavoriteBaseException("No se encontró elementos")))
                .collectList()
                .flatMap(list-> ServerResponse.ok().body(Mono.just(list), Favorite.class));
    }

}
