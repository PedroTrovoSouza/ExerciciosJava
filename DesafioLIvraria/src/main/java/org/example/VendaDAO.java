package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class VendaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public VendaDAO() {
        emf = Persistence.createEntityManagerFactory("desafiolivraria");
        em = emf.createEntityManager();
    }

    public void cadastrarVenda(Venda venda) {
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public long selecionarUltimaVenda() {
        List resultado;
        Query consulta = em.createQuery("SELECT COUNT(v.idVenda) from Venda v");
        resultado = consulta.getResultList();
        return (long) resultado.get(0);
    }

    public List<Venda> listarTodasVendas() {
        Query consulta = em.createQuery("SELECT v FROM Venda v");
        return consulta.getResultList();
    }
}