package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestAccountMovement {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery("select distinct c from Account c left join fetch c.movements");

        List<Account> accounts = query.getResultList();

        for (Account account : accounts) {
            System.out.println("Holder: " + account.getHolder());
            System.out.println("Number of movements ...: " + account.getMovements().size());
        }
    }

}