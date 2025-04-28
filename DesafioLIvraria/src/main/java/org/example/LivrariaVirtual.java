package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jakarta.persistence.*;

public class LivrariaVirtual {
    private final int MAX_IMPRESSOS = 10;
    private final int MAX_ELETRONICOS = 20;
    private final int MAX_VENDAS = 50;
    private int numImpressos;
    private int numEletronicos;
    private int numVendas;
    private List<Impresso> impressos = new ArrayList<>();
    private List<Eletronico> eletronicos = new ArrayList<>();
    private List<Venda> venda = new ArrayList<>();

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafiolivraria");

    public LivrariaVirtual() {
    }

    public LivrariaVirtual(int numImpressos, int numEletronicos, int numVendas) {
        this.numImpressos = numImpressos;
        this.numEletronicos = numEletronicos;
        this.numVendas = numVendas;
    }

    private void preencherDadosComuns(Livro livro, String titulo, String autor, String editora, float preco) {
        livro.setTitulo(titulo);
        livro.setAutores(autor);
        livro.setEditora(editora);
        livro.setPreco(preco);
    }

    public void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Selecione as Opções de cadastro");
            System.out.println("1. Impresso");
            System.out.println("2. Digital");
            System.out.println("3. Ambos");

            int opcaoCadastro = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o título do livro:");
            String titulo = scanner.nextLine();
            System.out.println("Digite o autor:");
            String autor = scanner.nextLine();
            System.out.println("Digite a editora:");
            String editora = scanner.nextLine();
            System.out.println("Digite o preço:");
            float preco = scanner.nextFloat();

            if ((opcaoCadastro == 1 || opcaoCadastro == 3) && eletronicos.size() >= MAX_ELETRONICOS)  {
                System.out.println("Não à espaço suficiente na lista");
                return;
            }

            if ((opcaoCadastro == 2 || opcaoCadastro == 3) && impressos.size() >= MAX_IMPRESSOS) {
                System.out.println("Não à espaço suficiente na lista");
                return;
            }

            em.getTransaction().begin();

            switch (opcaoCadastro) {
                case 1 -> {
                    Impresso impresso = new Impresso();
                    preencherDadosComuns(impresso, titulo, autor, editora, preco);

                    System.out.println("Digite o frete:");
                    float frete = scanner.nextFloat();
                    System.out.println("Digite o estoque:");
                    int estoque = scanner.nextInt();

                    impresso.setFrete(frete);
                    impresso.setEstoque(estoque);

                    em.persist(impresso);

                    em.getTransaction().commit();
                    System.out.println("Livro cadastrado com sucesso!");
                    impressos.add(impresso);
                }
                case 2 -> {
                    Eletronico eletronico = new Eletronico();
                    preencherDadosComuns(eletronico, titulo, autor, editora, preco);

                    System.out.println("Digite o tamanho em MB:");
                    int tamanho = scanner.nextInt();

                    eletronico.setTamanho(tamanho);

                    em.persist(eletronico);

                    em.getTransaction().commit();
                    System.out.println("Livro cadastrado com sucesso!");
                    eletronicos.add(eletronico);
                }
                case 3 -> {
                    Impresso impresso = new Impresso();
                    preencherDadosComuns(impresso, titulo, autor, editora, preco);

                    System.out.println("Digite o frete:");
                    float frete = scanner.nextFloat();
                    System.out.println("Digite o estoque:");
                    int estoque = scanner.nextInt();

                    impresso.setFrete(frete);
                    impresso.setEstoque(estoque);

                    em.persist(impresso);

                    Eletronico eletronico = new Eletronico();
                    preencherDadosComuns(eletronico, titulo, autor, editora, preco);

                    System.out.println("Digite o tamanho em MB:");
                    int tamanho = scanner.nextInt();

                    eletronico.setTamanho(tamanho);

                    em.persist(eletronico);

                    em.getTransaction().commit();
                    System.out.println("Livros cadastrado com sucesso!");
                    impressos.add(impresso);
                    eletronicos.add(eletronico);
                }
                default -> System.out.println("Opção inválida!!!");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public static void realizarVenda() {
        Scanner teclado = new Scanner(System.in);
        Venda venda = new Venda();
        VendaDAO vendaDAO = new VendaDAO();
        Impresso impresso = new Impresso();
        Eletronico eletronico = new Eletronico();
        float valorVenda = 0;

        venda.setNumero((int) (Math.random() * 250) + 1);

        System.out.println("Informe seu nome: ");
        String nomeCliente = teclado.nextLine();
        venda.setCliente(nomeCliente);

        int ultimoID = selecionarUltimaVenda();
        venda.setNumVendas(selecionarUltimaVenda() + 1);

        System.out.println("Informe a quantidade de livros que deseja vender: ");
        int qtdLivros = teclado.nextInt();

        for(int i = 1; i <= qtdLivros; i++){
            System.out.println("Qual tipo do " + i + "livro?");
            System.out.println("""
                    <----- Selecione uma opção ----->
                    1 - Eletronico
                    2 - Impresso
                    """);
            int opcao = teclado.nextInt();

            System.out.println("Escolha o livro que deseja vender por id: ");

            if(opcao == 1){
                String lista = listarLivrosEletronicos();
                escolherOpcaoLivro(lista);
                int livroId = teclado.nextInt();
                Eletronico eletronicoPorId = getUmEletronico(livroId);
                valorVenda += eletronicoPorId.getPreco();
                venda.addLivro(eletronicoPorId);
                venda.setValor(valorVenda);
                vendaDAO.cadastrarVenda(venda);

            }else {
                String lista = listarLivrosImpressos();
                escolherOpcaoLivro(lista);
                int livroId = teclado.nextInt();
                Impresso impressoPeloID = getUmImpresso(livroId);
                valorVenda += impressoPeloID.getPreco() + impressoPeloID.getFrete();
                venda.addLivro(impressoPeloID);
                venda.setValor(valorVenda);
                vendaDAO.cadastrarVenda(venda);
            }
        }
    }

    public static List<Venda> listarVendas() {
        VendaDAO vendaDAO = new VendaDAO();
        List<Venda> totalVendas = vendaDAO.listarTodasVendas();
        totalVendas.forEach(v ->
                System.out.println("| Id: " + v.getIdVenda()+ " |Cliente: " + v.getCliente() + " |Número da venda: " + v.getNumero() + " |Valor total da venda: " + v.getValor() + "|"));
        return totalVendas;
    }

    public static Eletronico getUmEletronico(int idLivro) {
        EntityManager em = emf.createEntityManager();

        try {
            Eletronico eletronico = em.find(Eletronico.class, idLivro);
            return eletronico;
        } finally {
            em.close();
        }
    }

    public static Impresso getUmImpresso(int idLivro){
        EntityManager em = emf.createEntityManager();

        try {
           Impresso impresso = em.find(Impresso.class, idLivro);
            return impresso;
        } finally {
            em.close();
        }
    }

    public static int selecionarUltimaVenda() {
        VendaDAO vendaDAO = new VendaDAO();

        int numeroVenda = Integer.valueOf(String.valueOf(vendaDAO.selecionarUltimaVenda()));
        return numeroVenda;
    }


    public static String escolherOpcaoLivro(String lista){
        return "";
    }

    public static String listarLivrosImpressos() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Impresso> livrosDoBanco = em.createQuery("SELECT i FROM Impresso i", Impresso.class)
                    .getResultList();

            if (livrosDoBanco.isEmpty()) {
                System.out.println("Não há livros impressos cadastrados no banco.");
            } else {
                for (Impresso imp : livrosDoBanco) {
                    System.out.println(imp);
                }
            }
        } finally {
            em.close();
        }
        return null;
    }

    public static String listarLivrosEletronicos() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Eletronico> livrosDoBanco = em.createQuery("SELECT e FROM Eletronico e", Eletronico.class)
                    .getResultList();

            if (livrosDoBanco.isEmpty()) {
                System.out.println("Não há livros eletrônicos cadastrados no banco.");
            } else {
                for (Eletronico ele : livrosDoBanco) {
                    System.out.println(ele);
                }
            }
        } finally {
            em.close();
        }
        return null;
    }

    public void listarLivros() {
        listarLivrosImpressos();
        listarLivrosEletronicos();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivrariaVirtual livraria = new LivrariaVirtual();

        System.out.println("----------Livraria----------");

        boolean verdade = true;

        while(verdade) {
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Realizar uma venda");
            System.out.println("3. Listar livros");
            System.out.println("4. Listar vendas");
            System.out.println("5. Sair do programa");

            int opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1 -> {
                    livraria.cadastrarLivro();
                }
                case 2 -> {
                    realizarVenda();
                }
                case 3 -> {
                    System.out.println("Escolha oque deseja listar:");
                    System.out.println("1. Livros Impressos:");
                    System.out.println("2. Livros Eletronicos:");
                    System.out.println("3. Todos Livros:");

                    int opcaoListar = scanner.nextInt();

                    switch (opcaoListar) {
                        case 1 -> {
                            livraria.listarLivrosImpressos();
                        }
                        case 2 -> {
                            livraria.listarLivrosEletronicos();
                        }
                        case 3 -> {
                            livraria.listarLivros();
                        }
                    }
                }
                case 4 -> {
                    listarVendas();
                }
                case 5 -> {
                    verdade = false;
                    System.out.println("Saindo do sistema, Falou ✌");
                }
            }
        }
    }
}