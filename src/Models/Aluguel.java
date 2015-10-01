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
 * @author Diego Peixoto Classe Models para classe Aluguel
 */
public class Aluguel {

    private int cod = 0;
    private Cliente c;
    private Livro livrosAlugados;
    private Date dataAluguel;

    /**
     * Construtor da classe
     *
     * @param c - recebe o objeto cliente
     * @param livrosAlugados - recebe o objeto livro
     * @param dataAluguel - recebe a data em que foi efetuada a transação
     * @param cod
     */
    public Aluguel(Cliente c, Livro livrosAlugados, Date dataAluguel, int cod) {
        this.c = c;
        this.livrosAlugados = livrosAlugados;
        this.dataAluguel = dataAluguel;
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCliente(Cliente c) {
        this.c = c;
    }

    public Cliente getCliente() {
        return c;
    }

    public void setLivrosAlugados(Livro livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    public Livro getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    @Override
    public String toString() {
        return "\nCódigo para devolução: " + cod + "\nCliente: " + c + "\nLivro Alugado: " + livrosAlugados + "\nDataAluguel= " + dataAluguel;
    }

}
