
package br.univali.sisnet.correcao;

import br.univali.sisnet.prova.Prova;
import javax.servlet.http.HttpServletRequest;


public class CorrecaoCtrl {

    public Correcao obterCorrecao(Prova prova, HttpServletRequest req) {

        Correcao correcao = new Correcao();
        correcao.setProva(prova);

        for (int i = 1; i <= prova.getQuestoes().size(); i++) {
            int indice = Integer.parseInt(req.getParameter("respostaQuestao" + i));
            correcao.addIndiceResposta(indice);
        }

        correcao.setNota();

        return correcao;

    }

}
