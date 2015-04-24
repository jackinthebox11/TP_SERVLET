package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import fr.istic.tpservlet.domain.Heater;
import fr.istic.tpservlet.domain.Home;
import fr.istic.tpservlet.domain.Device;

	

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Home gethome(){
		
		Home h = new Home();
		h.setAdresse("rue de jole");
		Heater h1 = new Heater();
		h1.setPower("500w");
		Heater h2 = new Heater();
		h2.setPower("600w");
		List<Device> heaters = new ArrayList<Device>();
		heaters.add(h1);
		heaters.add(h2);
		h.setHeater(heaters);
		return h;
	}
}

