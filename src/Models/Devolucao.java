/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto
 * Classe Models para classe Devolucao
 */
public class Devolucao {

    private Date dataDevolucao;
    private Aluguel a;

    /**
     * Construtor da classe
     * @param a - recebe o objeto aluguel
     */
    public Devolucao(Aluguel a) {
        this.a = a;
        Date data = new Date();
        this.dataDevolucao = data;
    }

    public Aluguel getA() {
        return a;
    }

    public void setA(Aluguel a) {
        this.a = a;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Devolucao{" + "a=" + a + ", dataDevolucao=" + dataDevolucao + '}';
    }

}
