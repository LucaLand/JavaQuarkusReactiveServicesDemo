package luca.lan.controller;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import luca.lan.model.Fruit;
import luca.lan.restInterfaces.Service2API;
import luca.lan.service.HandlerService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;
import static org.jboss.resteasy.reactive.RestResponse.Status.NOT_ACCEPTABLE;

public class HandlerServiceController implements HandlerService1ControllerInterface{

    @Inject
    HandlerService handlerService;



    @Override
    @WithSession
    public Uni<Fruit> get(Long id) {
        return Fruit.findById(id);
    }

    @Override
    public Uni<Response> registerFruit(String fruitName, Long value) {
        return handlerService.registerFruit(fruitName)
                .onFailure().recoverWithItem(Response.notModified().build());
    }

    @Override
    public Uni<Response> expressionQuery(String exp) {
        if(handlerService.checkRequestExp(exp)){

        }
    }

}
