package Models;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto Classe Models para a classe Cliente
 */
public class Cliente {

    private String nome, telefone;
    private Long matricula;
    private int livrosAlugados = 0;
    private int qntdelivrosalugados = 0;

    /**
     * Construtor da classe
     *
     * @param nomeIn - recebe o nome do cliente
     * @param telefoneIn - recebe o telefone do cliente
     * @param matriculaIn - recebe o número de matrícula do cliente
     */
    public Cliente(String nomeIn, String telefoneIn, Long matriculaIn) {
        setNome(nomeIn);
        setTelefone(telefoneIn);
        setMatricula(matriculaIn);
        setLivrosAlugados(0);
        setQntdelivrosalugados(0);
    }

    public int getQntdelivrosalugados() {
        return qntdelivrosalugados;
    }

    public void setQntdelivrosalugados(int qntdelivrosalugados) {
        this.qntdelivrosalugados = qntdelivrosalugados;
    }

    public void setNome(String nomeIn) {
        this.nome = nomeIn;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefoneIn) {
        this.telefone = telefoneIn;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setMatricula(Long matriculaIn) {
        this.matricula = matriculaIn;
    }

    public Long getMatricula() {
        return matricula;
    }

    public int getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(int livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nTelefone: " + getTelefone() + "\nMatricula: " + getMatricula() + "\nQuantidade de livros alugados: "+getLivrosAlugados()+ "\n";
    }

}
