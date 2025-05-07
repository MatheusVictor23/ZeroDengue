package testes;

import dao.InternacaoDAO;

import exception.DaoException;
import model.CasoDengue;
import model.Internacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestaInternacao {
    private static void inserir() throws DaoException {
        InternacaoDAO internacaoDAO = new InternacaoDAO();

        Internacao internacao01 = new Internacao("Hospital 30 de Agosto");
        Internacao internacao02 = new Internacao("Hospital Adriano Silva");
        Internacao internacao03 = new Internacao("Hospital São Joaquim");

        List<Internacao> internacoes = new ArrayList<>();

        internacoes.add(internacao01);
        internacoes.add(internacao02);
        internacoes.add(internacao03);


        internacaoDAO.inserir(internacoes);
    }



    public static void main (String[] args) throws DaoException {
        inserir();
    }
}
