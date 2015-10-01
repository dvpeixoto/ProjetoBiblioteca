/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.RepositorioAluguel.alugados;
import static Controller.RepositorioCliente.listaCliente;
import static Controller.RepositorioLivro.listLivro;
import static Main.main.menuPrincipal;
import Models.Aluguel;
import Models.Cliente;
import Models.Devolucao;
import Models.Livro;
import Util.Console;
import java.util.Date;

/**
 * 
 * @author Tainara Specht
 * @author Diego Peixoto
 * Classe Controller para a classe Devolução
 */
public class RepositorioDevolucao {

    /**
     * Método para identificar o cliente que deseja efetuar uma devolução
     * @throws Exception 
     */
    public static void devolverLivro() throws Exception {
        try {
            long op = Console.scanLong("Informe o número de matrícula: ");
            for (Cliente listaCliente1 : listaCliente) {
                if (op == listaCliente1.getMatricula()) {
                    Cliente cli = listaCliente1;
                    menuDevolucao(cli);
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
    }

    /**
     * Método para devolução de livros emprestados
     * @param cli - recebe o objeto cliente
     * @throws Exception 
     */
    public static void menuDevolucao(Cliente cli) throws Exception {
        try {
            int opconsulta = Console.scanInt("Digite o código do aluguel: ");
            for (Aluguel alugados1 : alugados) {
                if (opconsulta == alugados1.getCod()) {
                    Devolucao devolucao = new Devolucao(alugados1);
                    alugados1.getLivrosAlugados().setDisponibilidade(true);
                    cli.setLivrosAlugados(cli.getLivrosAlugados() - 1);
                    System.out.println(devolucao);
                    System.out.println("Livro devolvido com sucesso!");
                    menuPrincipal();
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
        System.out.println("Informação não encontrada!");
        menuPrincipal();
    }
    
    
}
