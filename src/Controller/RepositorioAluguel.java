/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.RepositorioCliente.listaCliente;
import static Controller.RepositorioLivro.listLivro;
import static Main.main.menuPrincipal;
import Models.Aluguel;
import Util.Console;
import Models.Cliente;
import Models.Livro;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Tainara Specht
 * @author Diego Peixoto
 * 
 * Classe Controller para a Classe Aluguel
 */
public class RepositorioAluguel {
    static ArrayList<Aluguel> alugados = new ArrayList <Aluguel>();
    
    /**
     * Método responsável por validar o número de matrícula do cliente
     */
    public static void escolherLivro() throws Exception {
        try {
            long op = Console.scanLong("Informe o número de matrícula: ");
            for (Cliente listaCliente1 : listaCliente) {
                if (op == listaCliente1.getMatricula()) {
                    Cliente cli = listaCliente1;
                    menuAluguel(cli);
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
    }
 
    /**
     * Método responsável pelas opções referentes ao aluguel
     * @param cli - recebe o objeto cliente
     * @throws Exception 
     */
    public static void menuAluguel(Cliente cli) throws Exception {
        String opconsulta = "";
        while (!opconsulta.equals("5")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Visualizar todos livros: \n2- Pesquisar livro por titulo: \n3- Pesquisar livro por isbn: \n4- Alugar Livro: \n5- Voltar para o menu principal: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioLivro.VisualizarLivro();
                    break;
                }
                case "2": {
                    RepositorioLivro.PesquisarLivroTitulo();
                    break;
                }
                case "3": {
                    RepositorioLivro.PesquisarIsbn();
                    break;
                }
                case "4": {
                    alugarLivro(cli);
                    break;
                }
                case "5": {
                    menuPrincipal();
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        }
    }

    /**
     * Método responsável pelo aluguel dos livros (tratamento e registro)
     * @param cli - recebe o objeto cliente
     * @throws Exception 
     */
    public static void alugarLivro(Cliente cli) throws Exception {
        try {
            long op = Console.scanLong("Informe o número do isbn do livro que deseja alugar: ");
            for (Livro listaLivros : listLivro) {
                if (op == listaLivros.getIsbn()) {
                    if (listaLivros.isDisponibilidade() == true) {
                        if (cli.getLivrosAlugados() < 3) {
                            Date data = new Date();
                            int cod = gerarCod();
                            Aluguel aluguel = new Aluguel(cli, listaLivros, data, cod);
                            alugados.add(aluguel);
                            listaLivros.setDisponibilidade(false);
                            listaLivros.setQntdeTotalAlugado(listaLivros.getQntdeTotalAlugado() + 1);
                            cli.setQntdelivrosalugados(cli.getQntdelivrosalugados() + 1);
                            cli.setLivrosAlugados(cli.getLivrosAlugados() + 1);
                            System.out.println(aluguel);
                            System.out.println("Livro alugado com sucesso!");
                            return;
                        } else {
                            System.out.println("Você ja alugou o máximo de livros possíveis!");
                        }
                    } else {
                        System.out.println("Livro já está alugado!");
                    }
                } else {
                    System.out.println("Livro não cadastrado!");
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
        return;
    }

    /**
     * Método responsável por randomizar um código (tratamento)
     * @return var
     */
    public static int randomCod() {
        Date n = new Date();
        int cod = (int) n.getTime();
        return cod;
    }
    
    /**
     * Método responsável por gerar e guardar o código randomizado (tratamento e registro)
     * @return var
     */
    public static int gerarCod() {
        int cod = randomCod();
        return cod;
    }
    
    
}
