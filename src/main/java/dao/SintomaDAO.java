package dao;

import exception.DaoException;
import model.CasoDengue;
import model.Sintoma;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SintomaDAO {

    public void inserir(Sintoma sintoma) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(sintoma);

            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Sintoma consultar (Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();

        Sintoma sintoma = entityManager.find(Sintoma.class, id);

        return sintoma;
    }
}
