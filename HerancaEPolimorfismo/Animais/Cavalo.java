package HerancaEPolimorfismo.Animais;

public class Cavalo extends Animal{
    @Override
    public void setMoverse(String moverse) {
        super.setMoverse(moverse);
    }

    @Override
    public String getMoverse() {
        return "Correr";
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public int getIdadde() {
        return super.getIdadde();
    }

    @Override
    public void setIdadde(int idadde) {
        super.setIdadde(idadde);
    }

    @Override
    public String getSom() {
        return super.getSom();
    }

    @Override
    public void setSom(String som) {
        super.setSom(som);
    }
}
