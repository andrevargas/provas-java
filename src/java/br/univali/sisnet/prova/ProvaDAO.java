
package br.univali.sisnet.prova;

import br.univali.sisnet.banco.GerenciadorBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProvaDAO extends GerenciadorBanco {

    public void salvarProva(Prova prova) {

        String sql = "INSERT INTO prova (nome) VALUES (?);";

        try {

            PreparedStatement ps = obterConexao().prepareStatement(sql);
            ps.setString(1, prova.getNome());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<Prova> obterProvas() {

        String sql = "SELECT * FROM prova";

        try {

            PreparedStatement ps = obterConexao().prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            ArrayList<Prova> provas = new ArrayList<>();

            while(resultado.next()) {

                Prova prova = new Prova();
                prova.setId(resultado.getInt("id"));
                prova.setNome(resultado.getString("nome"));

                provas.add(prova);

            }

            return provas;

        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return null;
    }

    public Prova obterProvaPorId(int idProva) {

        String sql = "SELECT * FROM prova WHERE id = ?";

        try {

            PreparedStatement ps = obterConexao().prepareStatement(sql);
            ps.setInt(1, idProva);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                Prova prova = new Prova();
                prova.setId(resultado.getInt("id"));
                prova.setNome(resultado.getString("nome"));

                return prova;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return null;

    }

}
