package com.matheus.finances.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(query="select distinct avg(m.value) from Movement m where m.account=:pAccount "
        + "and m.movementType=:pType" +
        " group by m.date", name="MediaByDayAndType")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String holder;
    private String bank;
    private String agency;
    private String number;

    @OneToOne
    @JoinColumn(unique=true)
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Movement> movements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}