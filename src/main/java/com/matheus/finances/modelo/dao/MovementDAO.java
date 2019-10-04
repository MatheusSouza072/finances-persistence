package com.matheus.finances.modelo.dao;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.modelo.MovementType;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovementDAO {
    private EntityManager em;

    public MovementDAO(EntityManager manager) {
        this.em = manager;
    }

    public List<Double> getMediaByDayAndTipo(MovementType movementType, Account account) {

        String jpql = "select distinct avg(m.value) from Movement m where m.account=:pAccount "
                + "and m.movementType=:pType" +
                " group by m.date";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);

        query.setParameter("pAccount", account);
        query.setParameter("pType", movementType);

        return query.getResultList();

    }
}