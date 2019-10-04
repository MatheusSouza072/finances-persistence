package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestSearchAccount {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Account Account = em.find(Account.class, 1);

        Account.setHolder("Matheus");

        System.out.println(Account.getHolder());

        em.getTransaction().commit();
    }

}
