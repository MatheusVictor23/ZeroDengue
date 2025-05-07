package dao;

import exception.DaoException;
import model.Evolucao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EvolucaoDAO {
    public void inserir(List<Evolucao> evolucoes) throws DaoException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (Evolucao evolucao : evolucoes) {
            entityManager.persist(evolucao);
        }
        entityManager.getTransaction().commit();
    }

}
