package testes;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.close();
        System.out.println("Tabelas geradas com sucesso!");
    }
}