/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

import java.sql.*;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import cadastrobd.model.util.SequenceManager;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CadastroBDTeste {

    public static void main(String[] args) throws SQLException {
        PessoaFisicaDAO PFisicaDao = new PessoaFisicaDAO();
        SequenceManager sequenceCode = new SequenceManager();
        int nextValue = sequenceCode.getValue("CodigoPessoa");

        //Instanciar uma pessoa física e persistir no banco de dados.
        PessoaFisica PessoaF = new PessoaFisica("00099900099", nextValue, "Pedro de Souza",
                "Rua das Flores", "Quissama", "RJ", "2512968000", "pedro@gmail.com");
        PFisicaDao.incluir(PessoaF);

        //Alterar os dados da pessoa física no banco.
        PessoaF.setCidade("Macae");
        PessoaF.setEstado("RJ");
        PFisicaDao.alterar(PessoaF);

        //Consultar todas as pessoas físicas do banco de dados e listar no console.
        ArrayList<PessoaFisica> resultadoP = PFisicaDao.getPessoas();
        resultadoP.forEach(item -> item.exibir());

        //Excluir a pessoa física criada anteriormente no banco.
        PFisicaDao.excluir(PessoaF);
        PFisicaDao.close();

        PessoaJuridicaDAO PJuridicaDao = new PessoaJuridicaDAO();
        nextValue = sequenceCode.getValue("CodigoPessoa");
        //Instanciar uma pessoa jurídica e persistir no banco de dados.
        PessoaJuridica PessoaJ = new PessoaJuridica("00333999000199", nextValue, "Happy Salad ltda", "Rua Mendes n003",
                "Macae", "RJ", "6540662500", "happysalad@happysalas.com.br");
        PJuridicaDao.incluir(PessoaJ);

        //Alterar os dados da pessoa jurídica no banco.
        PessoaJ.setLogradouro("Avenida Abelardo, Vila Rosali nº 1997");
        PJuridicaDao.alterar(PessoaJ);

        //Consultar todas as pessoas jurídicas do banco e listar no console.
        ArrayList<PessoaJuridica> resultadoJ = PJuridicaDao.getPessoas();
        resultadoJ.forEach(item -> item.exibir());

        //Excluir a pessoa jurídica criada anteriormente no banco.
        PJuridicaDao.excluir(PessoaJ);
        PJuridicaDao.close();
    }
}
