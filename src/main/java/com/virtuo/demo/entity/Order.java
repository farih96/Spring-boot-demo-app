package com.virtuo.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;
    private String name;
    private String type;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    public Order(int id, String number, String name, String type, Client client) {
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
