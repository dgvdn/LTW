package kell.hotel.service;

import kell.hotel.model.Client;

public interface ClientService {
    Client findByEmail(String email);

    Client save(Client client);

}
