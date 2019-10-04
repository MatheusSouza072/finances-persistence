package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.modelo.Movement;
import com.matheus.finances.modelo.MovementType;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TestJPARelationship {
    public static void main(String[] args) {

        Account account = new Account();
        account.setAgency("111");
        account.setBank("Itau");
        account.setNumber("54321");
        account.setHolder("Matheus");

        Movement movement = new Movement();
        movement.setDate(Calendar.getInstance());
        movement.setDescription("SteakHouse");
        movement.setMovementType(MovementType.EXIT);
        movement.setValue(new BigDecimal("200.0"));

        movement.setAccount(account);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(account);
        manager.persist(movement);

        manager.getTransaction().commit();
        manager.close();

    }

}