package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Tainara Specht
 * @author Diego Peixoto Classe Models para a classe Livro
 */
public class Livro {

    private Long isbn;
    private String titulo, editora, autor, anoPublicacao;
    private boolean disponibilidade;
    private int qntdeTotalAlugado = 0;

    /**
     * Construtor da classe
     *
     * @param isbnIn - recebe o ISBN do livro
     * @param tituloIn - recebe o título do livro
     * @param autorIn - recebe o autor do livro
     * @param editoraIn - recebe a editora do livro
     * @param anoPublicacaoIn - recebe o ano da publicação do livro
     */
    public Livro(Long isbnIn, String tituloIn, String autorIn, String editoraIn, String anoPublicacaoIn) {
        setIsbn(isbnIn);
        setTitulo(tituloIn);
        setAutor(autorIn);
        setEditora(editoraIn);
        setAnoPublicacao(anoPublicacaoIn);
        setDisponibilidade(true);
        setQntdeTotalAlugado(0);
    }

    public int getQntdeTotalAlugado() {
        return qntdeTotalAlugado;
    }

    public void setQntdeTotalAlugado(int qntdeTotalAlugado) {
        this.qntdeTotalAlugado = qntdeTotalAlugado;
    }

    public void setIsbn(Long isbnIn) {
        this.isbn = isbnIn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setTitulo(String tituloIn) {
        this.titulo = tituloIn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autorIn) {
        this.autor = autorIn;
    }

    public String getAutor() {
        return autor;
    }

    public void setEditora(String editoraIn) {
        this.editora = editoraIn;
    }

    public String getEditora() {
        return editora;
    }

    public void setAnoPublicacao(String anoPublicacaoIn) {
        this.anoPublicacao = anoPublicacaoIn;
    }

    public String getAnoPublicacao() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(anoPublicacao);

    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + "\nTitulo: " + titulo + "\nAutor: " + autor + "\nEditora: " + editora + "\nAno da Publicação: " + anoPublicacao+"\n";
    }

}
