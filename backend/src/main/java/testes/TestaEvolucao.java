package testes;

import dao.EvolucaoDAO;
import exception.DaoException;
import model.CasoDengue;
import model.Evolucao;

import java.util.ArrayList;
import java.util.List;

public class TestaEvolucao {

    private static void inserir() throws DaoException {
        EvolucaoDAO evolucaoDAO = new EvolucaoDAO();

        Evolucao evolucao01 = new Evolucao("Grave");
        Evolucao evolucao02 = new Evolucao("Melhora");
        Evolucao evolucao03 = new Evolucao("Alta");

        List<Evolucao> evolucoes = new ArrayList<>();
        evolucoes.add(evolucao01);
        evolucoes.add(evolucao02);
        evolucoes.add(evolucao03);

        evolucaoDAO.inserir(evolucoes);
    }

    public static void main(String[] args) throws DaoException {
        inserir();
    }
}
