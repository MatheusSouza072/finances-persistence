package com.matheus.finances.test;


import com.matheus.finances.modelo.Account;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestAccount {

        public static void main(String[] args) { Account account = new Account();


        account.setHolder("Matheus");
        account.setBank("Caixa Economica");
        account.setAgency("123");
        account.setNumber("456");


        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();

        em.close();
        em.close();
    }

}


