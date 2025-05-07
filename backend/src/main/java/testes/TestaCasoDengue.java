package testes;

import dao.*;
import exception.DaoException;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestaCasoDengue {


    private static void inserirCaso() throws DaoException {

        LocalDate dataNascimento = LocalDate.of(2006, 5, 23);
        LocalDate dataInicioSintomas = LocalDate.of(2025, 5, 2);

        CasoDengue casoDengue1 = new CasoDengue("Matheus", "3242342", dataNascimento, "18", "M", "AAa", "Rua A", "11", "Perpétuo", dataInicioSintomas);

        CasoDengueDAO casoDengueDAO = new CasoDengueDAO();
        try{
            EntityManager entityManager = JPAUtil.getEntityManager();

            Cidade cidade = entityManager.find(Cidade.class, 1L);
            Internacao internacao = entityManager.find(Internacao.class, 2L);

            Sintoma sintoma01 = entityManager.find(Sintoma.class, 1L);
            Sintoma sintoma02 = entityManager.find(Sintoma.class, 2L);
            List<Sintoma> sintomas = new ArrayList<>();
            sintomas.add(sintoma01);
            sintomas.add(sintoma02);

            Evolucao evolucao = entityManager.find(Evolucao.class, 1L);


            casoDengue1.setCidade(cidade);
            casoDengue1.setLocalInternacao(internacao);
            casoDengue1.setSintomas(sintomas);
            casoDengue1.setEvolucao(evolucao);

            casoDengueDAO.inserir(casoDengue1);

        }catch(Exception e){
            throw new DaoException(e);
        }

    }

    private static void listarCasos() {
        CasoDengueDAO casoDengueDAO = new CasoDengueDAO();

        List<CasoDengue> casos = casoDengueDAO.listar();

        for (CasoDengue caso : casos) {
            System.out.println(caso);
        }
    }


    public static void main(String[] args) throws DaoException {
        //listarCasos();
        inserirCaso();
    }
}
