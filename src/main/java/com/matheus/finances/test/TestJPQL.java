package com.matheus.finances.test;

import com.matheus.finances.modelo.Account;
import com.matheus.finances.modelo.Movement;
import com.matheus.finances.modelo.MovementType;
import com.matheus.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestJPQL {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Account account = new Account();
        account.setId(1);

        Query query = manager
                .createQuery("select m from Movement m where m.account=:pAccount "
                        + "and m.type = :pType order by m.value desc");

        query.setParameter("pAccount", account);
        query.setParameter("pType", MovementType.INPUT);

        List<Movement> movements = query.getResultList();

        for (Movement m : movements) {
            System.out.println("Description: " + m.getDescription());
            System.out.println("Account.id:" + m.getValue());
        }
    }


}
