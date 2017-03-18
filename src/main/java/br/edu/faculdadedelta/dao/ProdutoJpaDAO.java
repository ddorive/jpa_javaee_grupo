package br.edu.faculdadedelta.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.faculdadedelta.modelo.Produto;
 
public class ProdutoJpaDAO {
 
	private EntityManager em;
	   
	  public ProdutoJpaDAO(EntityManager em) {
	  this.em = em;
	  }
	   
	  public void adicionarProduto(Produto produto) {
	  em.persist(produto);
	  }
	   
	  public Produto getProduto(int id) {
	  return getTodosProdutos().get(id);
	  }
	   
	  public void removerProduto(int id) {
	  em.remove(getProduto(id));
	  }
	   
	  public void atualizarProduto(Produto produto) {
	  em.merge(produto);
	  }
	   
	  public List<Produto> getTodosProdutos() {
	  return em.createQuery("SELECT produto FROM Produto produto", Produto.class).getResultList();
	  }
}