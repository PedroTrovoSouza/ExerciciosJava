package atividadeSlides.Objetos;

class Carro {
    private String cor;
    private String modelo;
    private double velocidadeAtual;
    private double velocidadeMaxima;
    private Motor motor;

    public String getCor()
    {
        return cor;
    }
    public void setCor(String cor)
    {
        this.cor = cor;
    }
    public String getModelo()
    {
        return modelo;
    }
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }


    void liga() {
        System.out.println("Carro ligado!");
    }

    void acelera(double quantidade) {
        double velocidadeNova = this.velocidadeAtual + quantidade;
        if (velocidadeNova > this.velocidadeMaxima) {
            System.out.println("Atribuída a velocidade máxima.");
            this.velocidadeAtual = this.velocidadeMaxima;
        } else {
            this.velocidadeAtual = velocidadeNova;
        }
    }


    int retornaMarchaAtual() {
        if (this.velocidadeAtual < 0) {
            return -1;
        }
        if (this.velocidadeAtual >= 0 && this.velocidadeAtual < 40) {
            return 1;
        }
        if (this.velocidadeAtual >= 40 && this.velocidadeAtual < 80) {
            return 2;
        }
        return 3;
    }
}
