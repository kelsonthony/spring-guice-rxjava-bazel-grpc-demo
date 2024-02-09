package com.kelsonthony.springguicerxjavabazelgrpcdemo.springguicerxjavabazelgrpcdemo.domain.exception;

public class ClientNotFoundException extends EntityNotFoundException {

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(Long clientId) {
        this(String.format("There is no client record with the code %d", clientId));
    }
}
