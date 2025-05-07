package dao;

import exception.DaoException;
import model.Cidade;
import model.Estado;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDAO {

    public List<Estado> listar() throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();

            Query consulta = entityManager.createQuery("select e from Estado e");

            List<Estado> estados = consulta.getResultList();

            return estados;

        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Estado consultar(long id) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();
            Estado estado = entityManager.find(Estado.class, id);
            return estado;
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void inserir(Estado estado) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(estado);
            entityManager.getTransaction().commit();

        }catch (Exception e){
            throw new DaoException(e);
        }
    }

    public void inserirEstados(List<Estado> estados) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            for (Estado estado : estados) {
                entityManager.persist(estado);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void inserirCidadesNoEstado(long id, List<Cidade> cidades) throws DaoException {
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();

            Estado estado = entityManager.find(Estado.class, id);
            for(Cidade cidade: cidades){
                cidade.setEstado(estado);
                entityManager.persist(cidade);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }
}
