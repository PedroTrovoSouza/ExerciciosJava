package org.controleEstoque.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.controleEstoque.modelo.Produto;
import org.controleEstoque.testes.ListaTodosProdutos;

import java.util.List;

public class RepositorioProdutos {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleestoque");

    public void salvarNoBanco(Produto produto) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void alterarProduto(int id, double preco){
        EntityManager em = emf.createEntityManager();
        Produto produtoEncontrado = em.find(Produto.class, id);

        try {
            em.getTransaction().begin();
            produtoEncontrado.setPreco(preco);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public void removerProduto(int id){
        EntityManager em = emf.createEntityManager();
        Produto produtoEncontrado = em.find(Produto.class, id);

        try {
            em.getTransaction().begin();
            em.remove(produtoEncontrado);
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public List<Produto> buscarTodosProdutos(){
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = em.createQuery("from Produto", Produto.class).getResultList();
        em.close();
        return produtos;
    }

}
