package com.virtuo.demo.controller;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService  clientService;

    @RequestMapping("/{id}")
    public String findClientById(@PathVariable("id") int id){
        Client Client = clientService.getClientById(id);
        return Client.getFirstName();
    }

    @GetMapping("/list")
    public String clientsList(Model model){
        List<Client> clients= clientService.getAllClients();
        model.addAttribute("clients", clients);
        return"client_list";
    }
    @GetMapping("/add")
    public String addClientForm(Model model) {
         model.addAttribute("client", new Client());
         return "client/add";
    }

    @PostMapping("/add")
    public String processAddClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/client/";
    }

    @GetMapping("/edit/{id}")
    public String updateClientForm(@PathVariable("id") int id,Model model) {
        Client client  = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client/edit";  
    }

    @PostMapping("/edit")
    public String processUpdateClient(Client client) {
        clientService.updateClient(client);
        return "redirect:/client/";
    }

    @PostMapping("/delete")
    public String deletePatient(Client client) {
         //clientService.deleteClient(client.getId())
         return "delete Client and their orders";
    }

}