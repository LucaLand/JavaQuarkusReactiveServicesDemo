package luca.lan.controller;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import luca.lan.model.Fruit;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/service")
@ApplicationScoped
public interface HandlerService1ControllerInterface {

//    @GET
//    public Uni<Response> request (@HeaderParam("v1") String value1, @HeaderParam("v2") String value2, @HeaderParam("op") String operation);

    @GET
    @Path("/{id}")
    public Uni<Fruit> get (Long id);

    @GET
    @Path("/register")
    public Uni<Response> registerFruit (@QueryParam("name") String fruitName, @QueryParam("value") Long value);

//    @GET
//    @Path("/add")
//    public Uni<Response> addition (@QueryParam("f1") String value1, @QueryParam("f2") String value2);

    @GET
    @Path("/exp")
    public Uni<Response> expressionQuery (@QueryParam("exp") String exp);

//    @GET
//    @Path("/sub")
//    public Uni<Response> subtraction (@QueryParam("f1") String value1, @QueryParam("f2") String value2);
//
//    @GET
//    @Path("/mult")
//    public Uni<Response> multiply (@QueryParam("f1") String value1, @QueryParam("f2") String value2);
//
//    @GET
//    @Path("/div")
//    public Uni<Response> division (@QueryParam("f1") String value1, @QueryParam("f2") String value2);



}
