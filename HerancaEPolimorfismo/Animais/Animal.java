package HerancaEPolimorfismo.Animais;

public class Animal {
    private String nome;
    private int idadde;
    private String som;
    private String moverse;

    public void setMoverse(String moverse){
        this.moverse = moverse;
    }

    public String getMoverse(){
        return moverse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdadde() {
        return idadde;
    }

    public void setIdadde(int idadde) {
        this.idadde = idadde;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }
}
