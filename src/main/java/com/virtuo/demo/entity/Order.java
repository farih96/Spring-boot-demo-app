package com.virtuo.demo.entity;

import javax.persistence.*;

@Entity
public class Order {

    /*
     Commande ( numéro de commande ,  nom de la commande , type de commande)
     - Un client peut avoir 0 ou plusieurs commandes
     -  Une commande appartient  à un et  un seul client
     */
    @Id
    @GeneratedValue
    private int id;
    private String number;
    private String name;
    private String type;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Order(String number, String name, String type, Client client) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.type = type;
        this.client = client;
    }

    public Order() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }
}
