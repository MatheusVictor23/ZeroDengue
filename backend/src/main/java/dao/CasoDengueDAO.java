package dao;

import exception.DaoException;
import model.CasoDengue;
import model.Sintoma;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CasoDengueDAO {
    public List<CasoDengue> listar(){
        EntityManager entityManager = JPAUtil.getEntityManager();

        Query consulta = entityManager.createQuery("select c from CasoDengue c");

        List<CasoDengue> casos = consulta.getResultList();

        return casos;
    }

    public CasoDengue consultar(Long id) throws DaoException {
        EntityManager entityManager = JPAUtil.getEntityManager();

        CasoDengue caso = entityManager.find(CasoDengue.class, id);

        return caso;
    }


    public void inserir(CasoDengue caso) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(caso);

            entityManager.getTransaction().commit();
        }catch(Exception e) {
            throw new DaoException(e);
        }
    }
}
