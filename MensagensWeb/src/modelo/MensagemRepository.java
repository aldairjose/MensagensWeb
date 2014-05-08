package modelo;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

public class MensagemRepository {
	private EntityManager manager ;
	
	 public MensagemRepository(EntityManager manager) {
	 this.manager = manager ;
	 }
	 public void adiciona (Mensagem mensagem) {
	 this.manager.persist(mensagem) ;
	 }
	

 public List <Mensagem> buscaTodos() {
	 Query query=(Query)this.manager.createQuery ("select x from evento x");
	  return((javax.persistence.Query) query).getResultList();
	 }}
 //Query query = this.manager.createQuery ( "select x from evento x " ) ; 
//return query.getResultList () ;

