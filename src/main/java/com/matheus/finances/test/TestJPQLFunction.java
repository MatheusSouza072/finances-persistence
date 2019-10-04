package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.modelo.MovementType;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestJPQLFunction {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Account account = new Account();
        account.setId(3);

        TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

        query.setParameter("pAccount", account);
        query.setParameter("pType", MovementType.EXIT);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            System.out.println(" media is: " + media);
        }

    }

}

