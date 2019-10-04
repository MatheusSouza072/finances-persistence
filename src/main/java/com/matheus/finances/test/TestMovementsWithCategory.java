package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.modelo.Category;
import com.matheus.finances.modelo.Movement;
import com.matheus.finances.modelo.MovementType;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TestMovementsWithCategory {
    public static void main(String[] args) {

        Category category1 = new Category("Travel");
        Category category2 = new Category("Business");

        Account account = new Account();
        account.setId(2);

        Movement movement1 = new Movement();
        movement1.setDate(Calendar.getInstance());
        movement1.setDescription("Travel to SP");
        movement1.setMovementType(MovementType.EXIT);
        movement1.setValue(new BigDecimal(100.0));
        movement1.setCategories(Arrays.asList(category1, category2));

        movement1.setAccount(account);

        Movement movement2 = new Movement();
        movement2.setDate(Calendar.getInstance());
        movement2.setDescription("Travel to RJ");
        movement2.setMovementType(MovementType.EXIT);
        movement2.setValue(new BigDecimal(300.0));
        movement2.setCategories(Arrays.asList(category1, category2));

        movement2.setAccount(account);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(category1); // 'categoria1' é Managed
        em.persist(category2);

        em.persist(movement1);
        em.persist(movement2);

        em.getTransaction().commit();
        em.close();

    }
}