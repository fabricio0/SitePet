package br.com.projetoPet.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.projetoPet.daoGeneric.DaoGenerico;
import br.com.projetoPet.factory.InstanceImg;
import br.com.projetoPet.templateImg.TemplateImg;
import br.com.projetoPet.util.Noticia;
import br.com.projetoPet.util.Usuario;

@SessionScoped
@ManagedBean(name = "benLogin")
public class BeanLogin {
	Usuario usuario = new Usuario();
	private UploadedFile file;

	public void uploadImg(FileUploadEvent event) {
		file = event.getFile();
	}
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
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			return "/resources/html/mainUser.xhtml";
		} else {
			usuario = new Usuario();
			usuario.setStatus("USUARIONAOLOGADO");
			addMessage("Email ou senha incorretos !");
		}
		return "";
	}

	public String editarMeuPerfil() {
		try {
			DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();
//			String img = "data:image/jpg;base64," + DatatypeConverter.printBase64Binary(this.getFile().getContents());
//			System.out.println(this.getFile().getContentType());
//			System.out.println(this.getFile().getSize());
			if (this.getFile() != null) {
				InstanceImg instanceImg = new InstanceImg();
				TemplateImg templateImg = instanceImg.buscarInstance(this.getFile().getContentType());
				usuario.setImagem(templateImg.upload(DatatypeConverter.printBase64Binary(this.getFile().getContents()),
						this.getFile().getContentType()));
//				System.out.println(noticiasAtt.getTitulo());
			}
			daoGenerico.mergeAtts(usuario);
			addMessage("Sucesso ao editar perfil");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro ao editar perfil");
		}
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
	

	public boolean autorizaPermissao(String situacao) {
		if (usuario.getCategoria().equalsIgnoreCase(situacao))
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
