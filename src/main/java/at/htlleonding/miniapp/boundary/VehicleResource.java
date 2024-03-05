package at.htlleonding.miniapp.boundary;

import at.htlleonding.miniapp.control.VehicleRepository;
import at.htlleonding.miniapp.entity.Vehicle;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @GET
    public Response getAll() {
        return Response.ok(vehicleRepository.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCar(Vehicle vehicle) {
        vehicleRepository.persist(vehicle);

        return Response.ok(vehicle.getId()).build();
    }

}
