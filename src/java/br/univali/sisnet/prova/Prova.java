
package br.univali.sisnet.prova;

import br.univali.sisnet.questao.Questao;
import java.util.ArrayList;


public class Prova {

    private int id;
    private ArrayList<Questao> questoes = new ArrayList<>();
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addQuestao(Questao questao) {
        questoes.add(questao);
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
