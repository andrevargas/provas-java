

package br.univali.sisnet.questao;

import java.util.ArrayList;


public class QuestaoCtrl {

    private final QuestaoDAO dao;

    public QuestaoCtrl() {
        dao = new QuestaoDAO();
    }

    public void salvarQuestao(int idProva, Questao questao) {
        dao.salvarQuestao(idProva, questao);
    }

    public ArrayList<Questao> obterQuestoesPorProva(int idProva) {
        return dao.obterQuestoesPorProva(idProva);
    }

}
