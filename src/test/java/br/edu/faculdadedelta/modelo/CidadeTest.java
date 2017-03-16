package br.edu.faculdadedelta.modelo;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import br.edu.faculdadedelta.util.JPAUtil;

public class CidadeTest {
	private EntityManager em;
	
	@Test
	public void deveSalvarCidade(){
		Cidade cidade = new Cidade();
		cidade.setNome("Goiânia");
		cidade.setUfCidade("GO");
		assertTrue("Não deve ter ID definido", cidade.isTransient());
		
		em.getTransaction().begin();
		em.persist(cidade);
		em.getTransaction().commit();
		
		assertFalse("Entidade agora deve ter ID definido", cidade.isTransient());
	}
	
	@Test
	public void devePesquisarCidades(){
		for(int i=0;i<10;i++){
			deveSalvarCidade();
		}
		
		TypedQuery<Cidade> query = em.createQuery("SELECT c FROM Cidade c", Cidade.class);
		List<Cidade> cidades = query.getResultList();
		
		assertFalse("deve ter encontrado um produto", cidades.isEmpty());
		assertTrue("deve ter encontrado vários produtos", cidades.size()>=10);
	}
	
	@Test
	public void deveAlterarCidade(){
		deveSalvarCidade();
		
		TypedQuery<Cidade> query = em.createQuery(" SELECT c FROM Cidade c", Cidade.class).setMaxResults(1);
		
		Cidade cidade = query.getSingleResult();
		
		assertNotNull("Dever ter encontrado cidade",cidade);
		
		Integer versao = cidade.getVersion();
		
		em.getTransaction().begin();
		
		cidade.setNome("Goianira");
		cidade = em.merge(cidade);
		
		em.getTransaction().commit();
		
		assertNotEquals("Versão deve ser diferente",versao, cidade.getVersion());
	}
	
	@Test
	public void deveExcluirCidade(){
		deveSalvarCidade();
		
		TypedQuery<Long> query = em.createQuery("SELECT MAX(c.id) FROM Cidade c",Long.class);
		Long id = query.getSingleResult();
		
		em.getTransaction().begin();
		Cidade cidade = em.find(Cidade.class, id);
		em.remove(cidade);
		em.getTransaction().commit();
		Cidade cidadeExcluida = em.find(Cidade.class, id);
		
		assertNull("Não deve encontrar cidade",cidadeExcluida);
	}
	
	@AfterClass
	public static void deveLimparBaseTeste(){
		EntityManager entityManager = JPAUtil.INSTANCE.getEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("DELETE FROM Cidade c");
		int qtdRegistrosExclidos = query.executeUpdate();
		entityManager.getTransaction().commit();
		
		assertTrue("Certifica que a base foi limpada",qtdRegistrosExclidos>0);
				
	}
	
	@Before
	public void instanciarEntityManager(){
		em=JPAUtil.INSTANCE.getEntityManager();
	}
	
	@After
	public void fecharEntityManagaer(){
		if(em.isOpen()){
			em.close();
		}
	}
}
