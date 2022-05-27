package kell.hotel.service.impl;

import kell.hotel.model.Client;
import kell.hotel.model.Role;
import kell.hotel.repository.ClientRepository;
import kell.hotel.repository.RoleRepository;
import kell.hotel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client save(Client client) {
        Client client1 = new Client();
        client1.setEmail(client.getEmail());
        client1.setFullName(client.getFullName());
        client1.setPhone(client.getPhone());
        client1.setIdCard(client.getIdCard());
        client1.setPassword(client.getPassword());
        client1.setRoles(Arrays.asList(roleRepository.findByName("CLIENT")));
        return clientRepository.save(client1);
    }
}
