package testes;

import dao.CidadeDAO;
import dao.EstadoDAO;
import exception.DaoException;
import model.Cidade;
import model.Estado;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TestaEstado {

    private static void inserirEstado() throws DaoException {
        Estado estado01 = new Estado("Amazonas");
        Estado estado02 = new Estado("Pará");

        List<Estado> estados = new ArrayList<>();
        estados.add(estado01);
        estados.add(estado02);


        EstadoDAO estadoDAO = new EstadoDAO();

        estadoDAO.inserirEstados(estados);
    }

    private static void inserirCidadesNoEstado() throws DaoException {

        EstadoDAO estadoDAO = new EstadoDAO();
        Cidade cidade01 = new Cidade("Belém");
        Cidade cidade02 = new Cidade("Santarém");
        Cidade cidade03 = new Cidade("Terra Santa");
        Cidade cidade04 = new Cidade("Alenquer");

        List<Cidade> cidades = new ArrayList<>();

        cidades.add(cidade01);
        cidades.add(cidade02);
        cidades.add(cidade03);
        cidades.add(cidade04);

        estadoDAO.inserirCidadesNoEstado(2L, cidades);
    }

    private static void listarEstados() throws DaoException {
        EstadoDAO estadoDAO = new EstadoDAO();

        List<Estado> estados = estadoDAO.listar();

        for(Estado estado : estados){
            System.out.println(estado);
        }
    }

    private static void listarCidadesEmUmEstado(long id) throws DaoException {
        CidadeDAO cidaeDAO = new CidadeDAO();

        List<Cidade> cidades = cidaeDAO.listar(id);

        for(Cidade cidade : cidades){
            System.out.println(cidade);
        }
    }


    public static void main(String[] args) throws DaoException {
        //inserirEstado();
        inserirCidadesNoEstado();
//        listarCidadesEmUmEstado(1);
    }
}
