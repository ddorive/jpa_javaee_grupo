package br.edu.faculdadedelta.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

        private EntityManagerFactory emf; 

        public EntityManager getEntityManager(){

                //responsavel pela persistencia
                return emf.createEntityManager();
        }
        public DAO() {
                //chamo ele de reprodutor da instância
                emf = Persistence.createEntityManagerFactory("JpaJavaeePU");

                /* o nome passado vem do arquivo persistence.xml que contém as configs
                 * para conexão com o BD.
                 */
        }}