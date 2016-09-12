

package br.univali.sisnet.banco;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class GerenciadorBanco {

    private final Connection conexao;

    public GerenciadorBanco() {
        conexao = ConexaoFactory.criarConexao();
    }

    public Connection obterConexao() {
        return conexao;
    }

    public void fecharConexao() throws SQLException{
        conexao.close();
    }

}
