
package br.univali.sisnet.correcao;

import br.univali.sisnet.prova.Prova;
import java.util.ArrayList;


public class Correcao {

    private Prova prova;
    private ArrayList<Integer> indicesRespostas = new ArrayList<>();
    private float nota;

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public float getNota() {
        return nota;
    }

    public void setNota() {

        float total = 0;

        for (int i = 0; i < prova.getQuestoes().size(); i++) {

            if (prova.getQuestoes().get(i).getAlternativaCorreta() == indicesRespostas.get(i)) {
                total += 2;
            }

        }

        this.nota = total;

    }

    public ArrayList<Integer> getIndicesRespostas() {
        return indicesRespostas;
    }

    public void setIndicesRespostas(ArrayList<Integer> indicesRespostas) {
        this.indicesRespostas = indicesRespostas;
    }

    public void addIndiceResposta(int indiceResposta) {
        indicesRespostas.add(indiceResposta);
    }

}
