

package br.univali.sisnet.questao;

import java.util.ArrayList;


public class Questao {

    private int id;
    private String enunciado;
    private ArrayList<String> alternativas = new ArrayList<>();
    private int alternativaCorreta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void addAlternativa(String alternativa) {
        alternativas.add(alternativa);
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

}
