package dao;

import exception.DaoException;
import model.Cidade;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CidadeDAO {
    public List<Cidade> listar(Long id) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("SELECT c FROM Cidade c WHERE c.estado.id = :id");
            consulta.setParameter("id", id);

            List<Cidade> cidades = consulta.getResultList();

            return cidades;
        }catch(Exception e){
            throw new DaoException(e);
        }

    }
}
