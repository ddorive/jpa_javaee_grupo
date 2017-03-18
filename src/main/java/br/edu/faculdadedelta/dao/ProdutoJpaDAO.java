package br.edu.faculdadedelta.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.faculdadedelta.modelo.Produto;


public class ProdutoJpaDAO extends DAO {

        public void salvar(Produto produto){
                //obtendo o EntityManager
                EntityManager em = getEntityManager();
                try{
                        //inicia o processo de transacao
                        em.getTransaction().begin();
                        //faz a persistencia
                        em.persist(produto);
                        //manda bala para o BD
                        em.getTransaction().commit();
                }catch (Exception e) {
                        //se der algo de errado vem parar aqui, onde eh cancelado
                        em.getTransaction().rollback();
                }
        }

        public List exibir(){
                EntityManager em = getEntityManager();
                try{
                        Query q = em.createQuery("select object(c) from Produto as c");

                return q.getResultList();}
                finally{
                        em.close();
                }
        }}