package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.service;

import com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private ClientRepository clientRepository;


}
