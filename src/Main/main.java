/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.RepositorioAluguel;
import Controller.RepositorioCliente;
import static Controller.RepositorioDevolucao.devolverLivro;
import Controller.RepositorioLivro;
import Util.Console;
import static java.lang.System.exit;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto
 * Classe principal do sistema
 */
public class main {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        menuPrincipal();
    }

    /**
     * Método para exibir o menu principal
     * @throws Exception 
     */
    public static void menuPrincipal() throws Exception {
        String op = "";
        while (!op.equals("5")) {
            op = Console.scanString("\nEscolha uma opção: \n1- Cliente: \n2- Livro: \n3- Alugar Livro: \n4- Devolver Livro: \n5- Relatórios: \n6- Sair do Programa: ");
             switch (op) {
                case "1": {
                    menuCliente();
                    break;
                }
                case "2": {
                    menuLivro();
                    break;
                }
                case "3": {
                    RepositorioAluguel.escolherLivro();
                    break;
                }
                case "4": {
                    devolverLivro();
                    break;
                }
                case "5":{
                    menuRelatorio();
                }
                case "6":{
                    exit(6);
                }
                default: {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        }
    }

    /**
     * Método para exibir as opções relacionadas ao cliente
     * @throws Exception 
     */
    public static void menuCliente() throws Exception {
        String opconsulta = "";
        while (!opconsulta.equals("5")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Cadastrar Cliente: \n2- Visualizar todos os clientes: \n3- Pesquisar Cliente: \n4- Alterar Cliente: \n5- Voltar para o menu: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioCliente.CadastrarCliente();
                    menuCliente();
                    break;
                }
                case "2": {
                    RepositorioCliente.MostrarCliente();
                    menuCliente();
                    break;
                }
                case "3": {
                    menuPesquisarCliente();
                    break;
                }
                case "4": {
                    RepositorioCliente.alterarCliente();
                    break;
                }
                case "5": {
                    menuPrincipal();
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    menuCliente();
                    break;
                }
            }
        }
    }

    /**
     * Método para exibir as opções relacionadas aos livros
     * @throws Exception 
     */
    public static void menuLivro() throws Exception {
        String opconsulta = "";
        while (!opconsulta.equals("5")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Cadastrar Livro: \n2- Visualizar todos livros: \n3- Pesquisar livro: \n4- Alterar Livro: \n5- Voltar para o Menu: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioLivro.CadastrarLivro();
                    menuLivro();
                    break;
                }
                case "2": {
                    RepositorioLivro.VisualizarLivro();
                    menuLivro();
                    break;
                }
                case "3": {
                    menuPesquisarLivro();
                    break;
                }
                case "4": {
                    RepositorioLivro.alterarLivro();
                    break;
                }
                case "5": {
                    menuPrincipal();
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    menuLivro();
                    break;
                }
            }
        }
    }

    /**
     * Método para exibir um menu com opções relacionadas à pesquisa de livros
     * @throws Exception 
     */
    public static void menuPesquisarLivro() throws Exception {
        String opconsulta = "";
        
        while (!opconsulta.equals("3")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Pesquisar livro por titulo: \n2- Pesquisar livro por isbn: \n3- Voltar para o Menu: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioLivro.PesquisarLivroTitulo();
                    menuLivro();
                    break;
                }
                case "2": {
                    RepositorioLivro.PesquisarIsbn();
                    menuLivro();
                    break;
                }
                case "3": {
                    menuLivro();
                    break;
                }
            }
        }
    }
    
    /**
     * Método para exibir um menu de opções relacionadas à pesquisa de clientes
     * @throws Exception 
     */
    public static void menuPesquisarCliente() throws Exception {
        String opconsulta = "";
        
        while (!opconsulta.equals("2")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Pesquisar Cliente por nome: \n2- Pesquisar cliente por matrícula:  \n3- Voltar para o Menu: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioCliente.PesquisarCliente();
                    break;
                }
                case "2":{
                    RepositorioCliente.PesquisarMatricula();
                    break;
                }
                case "3": {
                    menuCliente();
                    break;
                }
            }
        }
    }
    
    /**
     * Método para exibir um menu de opções relacionadas à pesquisa de relatórios
     * @throws Exception 
     */
    public static void menuRelatorio() throws Exception{
        String opconsulta = "";
        
        while (!opconsulta.equals("5")) {
            opconsulta = Console.scanString("\nEscolha uma opção: \n1- Relatório de todos os livros: \n2- Relatório de livros disponíveis: \n3- Relatório de livros mais retirados: \n4- Relatório de clientes que mais alugaram livros: \n5- Voltar para o menu: ");
            switch (opconsulta) {
                case "1": {
                    RepositorioLivro.VisualizarLivro();
                    break;
                }
                case "2": {
                    RepositorioLivro.VisualizarLivroDisponivel();
                    break;
                }
                case "3": {
                    RepositorioLivro.livrosMaisRetirados();
                    break;
                }
                 case "4": {
                    RepositorioCliente.clientesQueMaisAlugam();
                    break;
                }
                case "5": {
                    menuPrincipal();
                    break;
                }
            }
        }
    }

}
