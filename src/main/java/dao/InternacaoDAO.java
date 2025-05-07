package dao;

import exception.DaoException;
import model.CasoDengue;
import model.Internacao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class InternacaoDAO {
    public void inserir(List<Internacao> locais) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            for(Internacao internacao: locais){
                entityManager.persist(internacao);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e);
        }

    }

    public Internacao consultar(long id) throws DaoException {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Internacao internacao = entityManager.find(Internacao.class, id);
        entityManager.getTransaction().commit();

        return internacao;
    }
}
