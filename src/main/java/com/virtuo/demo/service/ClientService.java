package com.virtuo.demo.service;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client getClientByName(String name) {
        return null;
    }

    public String deleteClient(int id) {
        clientRepository.deleteById(id);
        return "Client removed !! " + id;
    }

    public Client updateClient(Client Client) {
        return null;
    }
}
