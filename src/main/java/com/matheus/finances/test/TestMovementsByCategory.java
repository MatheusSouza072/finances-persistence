package com.matheus.finances.test;

import com.matheus.finances.modelo.Category;
import com.matheus.finances.modelo.Movement;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestMovementsByCategory {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Category category = new Category();
        category.setId(1);

        Query query = manager
                .createQuery("select m from Move m join m.category c where c = :pCategory");

        query.setParameter("pCategory", category);

        List<Movement> moves = query.getResultList();

        for (Movement m : moves) {
            System.out.println("\nDescription ..: " + m.getDescription());
            System.out.println("Value ......: R$ " + m.getValue());
        }

    }
}