package luca.lan.restInterfaces;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/service2")
@RegisterRestClient(configKey = "Service2-api")
public interface Service2API {
    @GET
    public Uni<Long> getKcal(@HeaderParam("id") Long id);

    @GET
    public Uni<String> insert(@HeaderParam("id") Long id, @HeaderParam("value") Long value);
}
