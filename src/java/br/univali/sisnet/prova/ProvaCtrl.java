
package br.univali.sisnet.prova;

import br.univali.sisnet.correcao.Correcao;
import br.univali.sisnet.correcao.CorrecaoCtrl;
import br.univali.sisnet.questao.Questao;
import br.univali.sisnet.questao.QuestaoCtrl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


public class ProvaCtrl {

    private final ProvaDAO dao;

    public ProvaCtrl() {
        dao = new ProvaDAO();
    }

    public ArrayList<Prova> obterProvas() {
        return dao.obterProvas();
    }

    public Prova obterProvaPorId(int idProva) {

        Prova prova = dao.obterProvaPorId(idProva);

        QuestaoCtrl questaoCtrl = new QuestaoCtrl();
        ArrayList<Questao> questoes = questaoCtrl.obterQuestoesPorProva(idProva);

        prova.setQuestoes(questoes);

        return prova;

    }

    public void salvarProva(HttpServletRequest req) {

        Prova prova = atribuirValores(req);
        long idProva = dao.salvarProva(prova);

        QuestaoCtrl questaoCtrl = new QuestaoCtrl();

        for (Questao questao: prova.getQuestoes()) {
            questaoCtrl.salvarQuestao(idProva, questao);
        }

    }

    private Prova atribuirValores(HttpServletRequest req) {

        Prova prova = new Prova();
        prova.setNome(req.getParameter("nome"));

        for (int i = 1; i <= 5; i++) {

            Questao questao = new Questao();
            questao.setEnunciado(req.getParameter("enunciadoQuestao" + i));

            for (int j = 1; j <= 5; j++) {
                String alternativa = req.getParameter("alternativa" + j + "Questao" + i);
                questao.addAlternativa(alternativa);
            }

            questao.setAlternativaCorreta(Integer.parseInt(req.getParameter("alternativaCorretaQuestao" + i)));

            prova.addQuestao(questao);
        }

        return prova;
    }

    public Correcao realizarProva(HttpServletRequest req) {

        Prova prova = obterProvaPorId(Integer.parseInt(req.getParameter("idProva")));

        CorrecaoCtrl correcaoCtrl = new CorrecaoCtrl();
        Correcao correcao = correcaoCtrl.obterCorrecao(prova, req);

        return correcao;

    }

}
