package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.controller;

import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.assembler.ClientModelAssembler;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.model.ClientModel;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.entity.ClientEntity;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PagedResourcesAssembler<ClientEntity> pagedResourcesAssembler;

    @Autowired
    private ClientModelAssembler clientModelAssembler;

    @GetMapping
    public PagedModel<ClientModel> listClient(@PageableDefault(size = 10)Pageable pageable) {
        Page<ClientEntity> clientPage = clientRepository.findAll(pageable);

        PagedModel<ClientModel> clientPageModel = pagedResourcesAssembler
                .toModel(clientPage, clientModelAssembler);

        return clientPageModel;
    }
}
