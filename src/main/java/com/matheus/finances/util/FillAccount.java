package com.matheus.finances.util;

import com.matheus.finances.modelo.Account;

import javax.persistence.EntityManager;

public class FillAccount {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Account account4 = new Account();
        Account account5 = new Account();

        account1.setBank("001 - BANCO DO BRASIL");
        account1.setNumber("16987-8");
        account1.setAgency("6543");

        account2.setBank("237 - BANCO BRADESCO");
        account2.setNumber("86759-1");
        account2.setAgency("1745");

        account3.setBank("341 - BANCO ITAU UNIBANCO");
        account3.setNumber("46346-3");
        account3.setAgency("4606");

        account4.setBank("033 - BANCO SANTANDER");
        account4.setNumber("12345-6");
        account4.setAgency("9876");

        account5.setBank("104 - CAIXA ECONOMICA FEDERAL");
        account5.setNumber("98654-3");
        account5.setAgency("1234");


        manager.persist(account1);
        manager.persist(account2);
        manager.persist(account3);
        manager.persist(account4);
        manager.persist(account5);

        manager.getTransaction().commit();

        manager.close();

    }
}