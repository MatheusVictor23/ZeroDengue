package testes;

import dao.SintomaDAO;
import exception.DaoException;
import model.Sintoma;

import java.time.LocalDate;

public class TestaSintomas {

    private static void inserir() throws DaoException {
        SintomaDAO sintomaDAO = new SintomaDAO();

        Sintoma sintoma = new Sintoma("Náusea");

        sintomaDAO.inserir(sintoma);
    }


    public static void main(String[] args) throws DaoException {
        inserir();
    }
}
