package Controller;

import static Main.main.menuCliente;
import static Main.main.menuPesquisarCliente;
import Models.Cliente;
import Util.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto
 *
 * Classe Controller para a Classe Cliente
 */
public class RepositorioCliente {

    static ArrayList<Cliente> listaCliente = new ArrayList<>();

    /**
     * Método para cadastrar clientes na base de dados
     */
    public static void CadastrarCliente() {
        String nome = null, telefone = null;
        long matricula = 0;

        try {
            nome = Console.scanString("Nome e sobrenome: ");
            while (validacaoNome(nome) != true) {
                nome = Console.scanString("Nome inválido, digite novamente:");
            }
            telefone = Console.scanString("Digite o número do Telefone, exemplo: (xx) xxxx-xxxx: ");
            while (isTelefone(telefone) != true) {
                telefone = Console.scanString("Número de telefone inválido, digite novamente:");
            }
            matricula = gerarMatricula();
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }

        Cliente c = new Cliente(nome, telefone, matricula);
        listaCliente.add(c);
    }

    /**
     * Método para mostrar clientes já cadastrados
     */
    public static void MostrarCliente() {
        listaCliente.stream().forEachOrdered((c) -> {
            System.out.println(c);
        });
        if (listaCliente.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
        }

    }

    /**
     * Método para pesquisar clientes já cadastrados, se houver
     */
    public static void PesquisarCliente() {
        String nomePesquisa;

        nomePesquisa = Console.scanString("Digite o nome do cliente a ser pesquisado: ");
        listaCliente.stream().forEach((c) -> {
            if (c.getNome().toUpperCase().equals(nomePesquisa.toUpperCase())) {
                System.out.println(c);

            }
        });
        if (listaCliente.isEmpty()) {
            System.out.println("Não há clientes na base de dados!");
        }
    }

    /**
     * Método que pesquisa o cliente pelo número de matrícula
     *
     * @throws Exception
     */
    public static void PesquisarMatricula() throws Exception {
        Long matriculaPesquisa;
        try {
            long op = Console.scanLong("Informe o número de matrícula: ");
            for (Cliente listaCliente1 : listaCliente) {
                if (op == listaCliente1.getMatricula()) {
                    System.out.println(listaCliente1);
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
    }

    /**
     * Método que altera o cadastro de algum cliente a partir do número de
     * matrícula
     *
     * @throws Exception
     */
    public static void alterarCliente() throws Exception {
        long matriculaInput = 0;
        try {
            matriculaInput = Console.scanLong("Digite o número de matrícula do cliente que deseja alterar: ");

            for (Cliente c : listaCliente) {
                if (c.getMatricula() == matriculaInput) {
                    System.out.println(c);
                    String op = "";
                    while (!op.equals("3")) {
                        System.out.println("\nEscolha uma opção: \n1- Alterar nome do cliente: \n2- Alterar telefone: \n3- Voltar para o menu: ");
                        op = Console.scanString("");

                        switch (op) {
                            case "1": {
                                String novoNome = Console.scanString("Digite o novo nome:");
                                while (validacaoNome(novoNome) != true) {
                                    novoNome = Console.scanString("Nome inválido, digite novamente:");
                                }
                                c.setNome(novoNome);
                                System.out.println("Nome alterado com sucesso!");
                                break;
                            }
                            case "2": {
                                String novoTelefone = Console.scanString("Digite o número do Telefone, exemplo: (xx) xxxx-xxxx: ");
                                while (isTelefone(novoTelefone) != true) {
                                    novoTelefone = Console.scanString("Número de telefone inválido, digite novamente:");
                                }
                                c.setTelefone(novoTelefone);
                                System.out.println("Número de telefone alterado com sucesso!");
                                break;
                            }
                            case "3": {
                                menuCliente();
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida.");
                            }
                        }
                    }
                } else {
                    System.out.println("Matricula não encontrada!");
                    menuCliente();
                }
            }
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }
    }

    /**
     * Método para validar se o nome do cliente está de acordo com as
     * especificações do sistema
     *
     * @param nomeDigitado
     * @return - retorna um valor booleano (true/false)
     */
    public static boolean validacaoNome(String nomeDigitado) {
        nomeDigitado = nomeDigitado.trim();
        boolean espacos = false;

        for (int i = 0; i < nomeDigitado.length(); i++) {
            char carac = nomeDigitado.charAt(i);
            if (Character.isLetter(carac) || Character.isWhitespace(carac)) {
                if (Character.isWhitespace(carac)) {
                    espacos = true;
                }
            } else {
                return false;
            }
        }
        return espacos == true;
    }

    /**
     * Método para padronizar a entrada de números de telefone
     *
     * @param novoTelefone
     * @return - retorna um valor booleano (true/false)
     */
    public static boolean isTelefone(String novoTelefone) {
        return novoTelefone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
                || novoTelefone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");

    }

    /**
     * Método para gerar um número de matrícula a partir da data e horário
     *
     * @return - retorna um número gerado para cadastro
     */
    public static long gerarMatricula() {
        long matricula = randomMatricula();
        while (verificaMatricula(matricula) != true) {
            matricula = randomMatricula();
            return matricula;
        }
        return matricula;
    }

    /**
     * Método utilizado para randomizar um número de mátricula
     *
     * @return
     */
    public static long randomMatricula() {
        Date n = new Date();
        long matriculaNumero = n.getTime();
        return matriculaNumero;
    }

    /**
     * Método utilizado para verificar se mátricula já existe
     *
     * @param matricula
     * @return
     */
    public static boolean verificaMatricula(long matricula) {
        for (Cliente listaCliente1 : listaCliente) {
            if (matricula != listaCliente1.getMatricula()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método utilizado para verficar quais clientes alugam mais livros
     */
    public static void clientesQueMaisAlugam() {
        Collections.sort(listaCliente, new ClienteCompAluguel());
        for (Cliente listaCliente1 : listaCliente) {
            System.out.println("Nome: " + listaCliente1.getNome() + " Matrícula: " + listaCliente1.getMatricula() + " Quantidade de Livros alugados: " + listaCliente1.getQntdelivrosalugados());

        }

    }
    
    /**
     * Método utilizado para comparar Classes
     */
    public static class ClienteCompAluguel implements Comparator<Cliente> {

        @Override
        public int compare(Cliente c1, Cliente c2) {
            return c2.getQntdelivrosalugados() - c1.getQntdelivrosalugados();
        }
    }

}
