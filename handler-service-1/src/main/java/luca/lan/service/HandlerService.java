package luca.lan.service;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.ws.rs.core.Response;
import luca.lan.model.Fruit;
import luca.lan.restInterfaces.Service2API;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

@ApplicationScoped
public class HandlerService {
    @RestClient
    Service2API service2API;

    @WithTransaction
    public Uni<Response> registerFruit(String fruitName) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        return Panache.withTransaction(fruit::persistAndFlush).replaceWith(Response.status(CREATED).entity(fruit).build())
                .onFailure().invoke(Throwable::printStackTrace);
    }


    public boolean checkRequestExp(String exp){
        AtomicBoolean res = new AtomicBoolean(true);
        exp.chars().forEach(value -> {
            if(!((value > 'a' && value < 'z') || value=='+' || value == '-'))
                res.set(false);
        });
        return res.get();
    }

    public void elaborateExpression (String exp){
        Iterator<Integer> stringIterator = exp.toLowerCase().chars().iterator();
        Integer c = 0;
        String fruitName;

        List<Integer> fruitValueList
        if(stringIterator.hasNext()) {
            do {

                c = stringIterator.next();
                if(c == '+'){

                    fruitName = "";
                }else if (c == '-') {
                    fruitName = "";
                }else{
                    fruitName +=c;
                }
            } while(stringIterator.hasNext() && c != '+' && c!='-');
        }
    }

}
