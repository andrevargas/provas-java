/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.sisnet.questao;

import br.univali.sisnet.banco.GerenciadorBanco;
import br.univali.sisnet.prova.ProvaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5973481
 */
public class QuestaoDAO extends GerenciadorBanco {

    public void salvarQuestao(long idProva, Questao questao) {

        String sql = "INSERT INTO questao ("
                + "id_prova, "
                + "enunciado, "
                + "alternativa_correta,"
                + "alternativa_1, "
                + "alternativa_2, "
                + "alternativa_3, "
                + "alternativa_4, "
                + "alternativa_5 "
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = obterConexao().prepareStatement(sql);
            ps.setLong(1, idProva);
            ps.setString(2, questao.getEnunciado());
            ps.setInt(3, questao.getAlternativaCorreta());

            for (int i = 0; i < questao.getAlternativas().size(); i++) {
                ps.setString(i + 4, questao.getAlternativas().get(i));
            }

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<Questao> obterQuestoesPorProva(int idProva) {

        String sql = "SELECT * FROM questao WHERE id_prova = ?";

        try {

            PreparedStatement ps = obterConexao().prepareStatement(sql);
            ps.setInt(1, idProva);

            ResultSet resultado = ps.executeQuery();

            ArrayList<Questao> questoes = new ArrayList<>();

            while(resultado.next()) {

                Questao questao = new Questao();
                questao.setId(resultado.getInt("id"));
                questao.setEnunciado(resultado.getString("enunciado"));
                questao.setAlternativaCorreta(resultado.getInt("alternativa_correta"));

                ArrayList<String> alternativas = new ArrayList<>();
                alternativas.add(resultado.getString("alternativa_1"));
                alternativas.add(resultado.getString("alternativa_2"));
                alternativas.add(resultado.getString("alternativa_3"));
                alternativas.add(resultado.getString("alternativa_4"));
                alternativas.add(resultado.getString("alternativa_5"));

                questao.setAlternativas(alternativas);

            }

            ps.close();
            resultado.close();

            return questoes;

        } catch (SQLException ex) {
            Logger.getLogger(ProvaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return null;

    }

}
