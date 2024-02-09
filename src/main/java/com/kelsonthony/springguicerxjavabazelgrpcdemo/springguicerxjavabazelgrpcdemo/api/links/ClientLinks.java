package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.links;

import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.controller.ClientController;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ClientLinks {

    public Link linktoClients(String rel) {
        return WebMvcLinkBuilder.linkTo(ClientController.class).withRel(rel);
    }

    public Link linktoClients() {
        return linktoClients(IanaLinkRelations.SELF.value());
    }
}
