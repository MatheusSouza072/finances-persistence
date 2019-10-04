package com.matheus.finances.modelo;

import javax.persistence.*;

public class Client {
    @Entity
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;

        @OneToOne(mappedBy = "client")
        @JoinColumn(unique = true)
        private Account account;
        private String address;
        private String profession;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }
    }

}