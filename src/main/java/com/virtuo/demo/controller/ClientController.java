package com.virtuo.demo.controller;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.entity.Order;
import com.virtuo.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService  clientService;

    @RequestMapping("/{id}")
    public String findClientById(@PathVariable("id") int id, Model model){
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        model.addAttribute("order", new Order());
        return "client-details";
    }

    @GetMapping("/list")
    public String clientsList(Model model){
        List<Client> clients= clientService.getAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute(new Client());
        return "clients-list";
    }

    @PostMapping("/add")
    public String processAddClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/client/list";
    }

    @GetMapping("/edit/{id}")
    public String updateClientForm(@PathVariable("id") int id,Model model) {
        Client client  = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client-edit";
    }

    @PostMapping("/edit")
    public String processUpdateClient(Client client) {
        clientService.updateClient(client);
        return "redirect:/client/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
         clientService.deleteClient(id);
         return "redirect:/client/list";
    }

}
