package controle;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax . persistence . EntityManager ;
import javax.servlet.http.HttpServletRequest ;

import modelo.Mensagem;
import modelo.MensagemRepository;
@ManagedBean("mensagemMB")
public class MensagemMB {
	
	
	
	 private Mensagem mensagem=new Mensagem();
	
	 public void adicionamensagem() {
	 EntityManager manager=this.getEntityManager() ;
	 MensagemRepository repository=new MensagemRepository(manager);
	
	 repository.adiciona (this.mensagem);
	 this.mensagem=new Mensagem();
	 }
	
	 public List <Mensagem> getMensagens() {
	 EntityManager manager=this.getEntityManager();
	 MensagemRepository repository=new MensagemRepository(manager);
	 return repository.buscaTodos();
	 }
	
	 private EntityManager getEntityManager() {
	 FacesContext fc=FacesContext . getCurrentInstance();
	 ExternalContext ec=fc.getExternalContext();
	 HttpServletRequest request=(HttpServletRequest)ec.getRequest();
	 EntityManager manager=(EntityManager) request.getAttribute("EntityManager");
	
	 return manager;
	 }

}
