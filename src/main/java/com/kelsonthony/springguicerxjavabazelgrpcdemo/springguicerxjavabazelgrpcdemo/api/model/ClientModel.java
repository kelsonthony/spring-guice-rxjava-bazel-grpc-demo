package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;


@Relation(collectionRelation = "clients")
@Setter
@Getter
public class ClientModel extends RepresentationModel<ClientModel> {

    private Long id;
    private String name;
    private BigDecimal payment;
}
