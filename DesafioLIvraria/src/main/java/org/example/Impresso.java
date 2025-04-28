package org.example;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LIVRO_IMPRESSO")
public class Impresso extends Livro {

    private float frete;
    private int estoque;

    public Impresso() {
        super();
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void atualizarEstoque(){
        this.estoque -= 1;
    }

    @Override
    public String toString() {
        return "\n📚 Livro Impresso\n" +
                "ID: " + getId() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Autor(es): " + getAutores() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Preço: R$ " + getPreco() + "\n" +
                "Frete: R$ " + frete + "\n" +
                "Estoque: " + estoque + " unidades\n";
    }

}