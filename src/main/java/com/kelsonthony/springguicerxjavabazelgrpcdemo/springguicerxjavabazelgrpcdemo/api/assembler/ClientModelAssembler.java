package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.assembler;

import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.controller.ClientController;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.links.ClientLinks;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.api.model.ClientModel;
import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClientModelAssembler
        extends RepresentationModelAssemblerSupport<ClientEntity, ClientModel> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientLinks clientLinks;

    public ClientModelAssembler() {
        super(ClientController.class, ClientModel.class);
    }

    @Override
    public ClientModel toModel(ClientEntity client) {
        ClientModel clientModel = createModelWithId(client.getId(), client);

        modelMapper.map(client, clientModel);

        clientModel.add(clientLinks.linktoClients("clients"));

        return clientModel;
    }
}
