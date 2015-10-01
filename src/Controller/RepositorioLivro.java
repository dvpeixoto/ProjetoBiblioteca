package Controller;

import static Main.main.menuLivro;
import static Main.main.menuPesquisarLivro;
import Models.Livro;
import Util.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto Classe Controller para a classe Livro
 */
public class RepositorioLivro {

    static ArrayList<Livro> listLivro = new ArrayList<>();

    /**
     * Método para cadastrar um novo livro e informações relacionadas
     */
    public static void CadastrarLivro() {
        long isbn = 0;
        String titulo = "", editora = "", autor = "", anoPublicacao = "";
        try {
            isbn = Console.scanLong("Digite o Código ISBN: ");
            while (verificaIsbn(isbn) == true) {
                isbn = Console.scanLong("isbn já existe no sistema, digite novamente:");
            }
            titulo = Console.scanString("Digite o título do livro: ");
            editora = Console.scanString("Digite a editora: ");
            autor = Console.scanString("Digite o(s) autor(es): ");
            anoPublicacao = Console.scanString("Digite o ano da publicação: ");
            while (validarAnoPublicacao(anoPublicacao) != true) {
                anoPublicacao = Console.scanString("Ano de publicação inválido, digite novamente: ");
            }

            Livro l = new Livro(isbn, titulo, editora, autor, anoPublicacao);
            listLivro.add(l);
        } catch (Exception e) {
            System.out.println("Formato inválido!");
        }
    }

    /**
     * Método para visualizar livros já cadastrados
     */
    public static void VisualizarLivro() {
        listLivro.stream().forEachOrdered((l) -> {
            System.out.println(l);
        });
        if (listLivro.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
        }
    }

    /**
     * Método para pesquisar um livro pelo título
     */
    public static void PesquisarLivroTitulo() {
        String tituloPesquisa;

        System.out.println("Digite o título do livro a ser pesquisado: ");
        tituloPesquisa = Console.scanString("");

        listLivro.stream().forEach((l) -> {
            if (l.getTitulo().toUpperCase().startsWith(tituloPesquisa.toUpperCase())) {
                System.out.println(l);
            }
        });
        if (listLivro.isEmpty()) {
            System.out.println("Livro não encontrado!");
        }
    }

    /**
     * Método para pesquisar livros pelo número de ISBN
     *
     * @throws Exception
     */
    public static void PesquisarIsbn() throws Exception {
        Long isbnPesquisa;
        try {
            isbnPesquisa = Console.scanLong("Digite o número do ISBN a ser pesquisado: ");
            listLivro.stream().forEach((Livro l) -> {
                if (isbnPesquisa == l.getIsbn()) {
                    System.out.println(l);
                } else {
                }
            });
            if (listLivro.isEmpty()) {
                System.out.println("ISBN não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Formato inválido!");
            menuPesquisarLivro();
        }
    }

//    public static void verificarDisponibilidade() {
//
//    }
    /**
     * Método para alterar dados de um livro já cadastrado
     *
     * @throws Exception
     */
    public static void alterarLivro() throws Exception {
        long isbnInput = 0;
        try {
            isbnInput = Console.scanLong("Digite o ISBN do livro que deseja alterar: ");
            for (Livro l : listLivro) {
                if (l.getIsbn() == isbnInput) {
                    System.out.println(l);
                    String op = "";
                    while (!op.equals("6")) {
                        System.out.println("\nEscolha uma opção: \n1- Alterar título do livro: \n2- Alterar editora: \n3- Alterar autor(es): \n4- Alterar ano da publicação: \n5- Alterar ISBN: \n6- Voltar para o menu: ");
                        op = Console.scanString("");
                        switch (op) {
                            case "1": {
                                String novoTitulo = Console.scanString("Digite o novo título:");
                                l.setTitulo(novoTitulo);
                                System.out.println("Título alterado com sucesso!");
                                break;
                            }
                            case "2": {
                                String novaEditora = Console.scanString("Digite o nome da nova editora:");
                                l.setEditora(novaEditora);
                                System.out.println("Editora alterada com sucesso!");
                                break;
                            }
                            case "3": {
                                String novoAutor = Console.scanString("Digite o nome do autor(es): ");
                                l.setAutor(novoAutor);
                                System.out.println("Autor(es) alterado com sucesso!");
                                break;
                            }
                            case "4": {
                                String novoAnoPublicacao = Console.scanString("Digite o ano da publicação: ");
                                while (validarAnoPublicacao(novoAnoPublicacao) != true) {
                                    novoAnoPublicacao = Console.scanString("Ano de publicação inválido, digite novamente:");
                                }
                                l.setAnoPublicacao(novoAnoPublicacao);
                                System.out.println("Ano da publicação alterado com sucesso!");
                                break;

                            }
                            case "5": {
                                try {
                                    long novoIsbn = Console.scanLong("Digite o ISBN: ");
                                    while (verificaIsbn(novoIsbn) == true) {
                                        novoIsbn = Console.scanLong("isbn já existe no sistema, digite novamente:");
                                    }
                                    l.setIsbn(novoIsbn);
                                    System.out.println("Isbn alterado com sucesso!");
                                    break;
                                } catch (Exception e) {
                                }
                            }
                            case "6": {
                                menuLivro();
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida.");
                            }
                        }
                    }
                } else {
                    System.out.println("Livro não encontrado!");
                    menuLivro();
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
    }

    /**
     * Método para padronizar o ano de publicação de um livro
     *
     * @param campo - recebe uma string referente ao ano
     * @return
     */
    public static boolean validarAnoPublicacao(String campo) {
        return campo.matches("[0-9]{4}+");
    }

    /**
     * Método para mostrar os livros mais alugados
     */
    public static void livrosMaisRetirados() {
        Collections.sort(listLivro, new livroCompRetirados());
        listLivro.stream().forEach((listLivro1) -> {
            System.out.println("Titulo: " + listLivro1.getTitulo() + " Isbn: " + listLivro1.getIsbn() + " Quantidade de vezes que foi alugado: " + listLivro1.getQntdeTotalAlugado());
        });

    }

    /**
     * Método utilizado para comparar a Classe
     */
    public static class livroCompRetirados implements Comparator<Livro> {

        @Override
        public int compare(Livro l1, Livro l2) {
            return l2.getQntdeTotalAlugado() - l1.getQntdeTotalAlugado();
        }
    }

    /**
     * Método utilizado para visualizar livros disponíveis para alugar
     */
    public static void VisualizarLivroDisponivel() {
        listLivro.stream().map((listLivro1) -> {
            if (listLivro1.isDisponibilidade() == true) {
                System.out.println(listLivro1);
            }
            return listLivro1;
        }).filter((_item) -> (listLivro.isEmpty())).forEach((_item) -> {
            System.out.println("Nenhum livro cadastrado!");
        });
    }

    /**
     * Método utilizado para verificar se já não existe isbn cadastrado
     *
     * @param isbn
     * @return
     */
    public static boolean verificaIsbn(long isbn) {
        for (Livro listLivro1 : listLivro) {
            if (isbn == listLivro1.getIsbn()) {
                return true;
            }
        }
        return false;
    }

}
