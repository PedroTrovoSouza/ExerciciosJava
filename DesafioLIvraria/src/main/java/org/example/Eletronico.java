package org.example;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LIVRO_ELETRONICO")
public class Eletronico  extends Livro{

    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "\n💻 Livro Eletrônico\n" +
                "ID: " + getId() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Autor(es): " + getAutores() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Tamanho: " + tamanho + " MB\n";
    }
}
