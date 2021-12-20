package com.virtuo.demo.service;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public String deleteClient(int id) {
        // deleted/softDelete orders too
        clientRepository.deleteById(id);
        return "Client removed !! " + id;
    }

    public Client updateClient(Client client) {
        Client clientToUpdate =  clientRepository.findById(client.getId()).orElse(null);

        if(clientToUpdate != null){
            clientToUpdate.setFirstName(client.getFirstName());
            clientToUpdate.setLastName(client.getLastName());
            clientToUpdate.setPhoneNumber(client.getPhoneNumber());
            clientToUpdate.setAddress(client.getAddress());
            clientToUpdate.setMailAddress(client.getMailAddress());
            saveClient(clientToUpdate);
        }
        return clientToUpdate;
    }
}
