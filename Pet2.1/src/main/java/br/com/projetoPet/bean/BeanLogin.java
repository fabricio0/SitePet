package br.com.projetoPet.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.projetoPet.daoGeneric.DaoGenerico;
import br.com.projetoPet.util.Usuario;

@ManagedBean(name = "benLogin")
@SessionScoped
public class BeanLogin {
	Usuario usuario = new Usuario();
	// usuario para ser inserido
	
	// homeUser
	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		usuario = (Usuario) session.getAttribute("usuarioLogado");
//		System.out.println(usuario);
//		System.out.println("USUaARIO LOPOST CRonss");
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setStatus("USUARIONAOLOGADO");
		}
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	// Funcao para login e inicio da sessão
	public String logar() {
		DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();
		usuario = (Usuario) daoGenerico.buscarUsuario(usuario);
		if (usuario != null) {
			addMessage("Entrou com sucesso !");
			usuario.setStatus("USUARIOLOGADO");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado",
					usuario);
			return "/resources/html/mainUser.xhtml";
		} else
			addMessage("Email ou senha incorretos !");
		return "";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		usuario = null;
		addMessage("Saiu com sucesso !");
		return "/resources/index.xhtml";
	}

	public boolean autoriza(String situacao) {
		if (usuario.getStatus().equalsIgnoreCase(situacao))
			return true;
		else
			return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
