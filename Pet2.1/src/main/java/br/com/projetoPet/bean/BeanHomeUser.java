package br.com.projetoPet.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.projetoPet.daoGeneric.DaoGenerico;
import br.com.projetoPet.util.Atividade;
import br.com.projetoPet.util.Noticia;
import br.com.projetoPet.util.Usuario;

@ViewScoped
@ManagedBean(name = "beanHomeUser")
public class BeanHomeUser {

	// homeUser

	private UploadedFile file;
	Usuario usuario = new Usuario();
	Usuario usuario2 = new Usuario();
	Noticia noticia = new Noticia();
	Atividade atividade = new Atividade();

	public String salvarNoticia() {
		try {
			DaoGenerico<Noticia> daoGenerico = new DaoGenerico<Noticia>();
			daoGenerico.inserir(noticia);
			addMessage("Sucesso ao inserir notícia");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro ao inserir notícia");
		}
		noticia = new Noticia();
		return "";
	}

	public String salvarAtividade() {
		try {
			DaoGenerico<Atividade> daoGenerico = new DaoGenerico<Atividade>();
//				usuario = (Usuario) daoGenerico.buscaId(Usuario.class,1L);
			atividade.setUsuario_id(usuario);
//				System.out.println(usuario.getNome());
			daoGenerico.inserir(atividade);
			addMessage("Sucesso ao inserir atividade");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addMessage("Erro ao inserir atividade");
		}
		atividade = new Atividade();
		return "";
	}

	public String editarNoticia() {
		try {
			DaoGenerico<Noticia> daoGenerico = new DaoGenerico<Noticia>();
//				System.out.println(noticiasAtt.getTitulo());
			daoGenerico.mergeAtts(noticia);
			addMessage("Sucesso ao editar notícia");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro ao editar notícia");
		}
		noticia = new Noticia();
		return "";
	}

	public String editarAtividade() {
		try {
			DaoGenerico<Atividade> daoGenerico = new DaoGenerico<Atividade>();
//				System.out.println(noticiasAtt.getTitulo());
			daoGenerico.mergeAtts(atividade);
			addMessage("Sucesso ao editar atividade");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro ao editar atividade");
		}
		noticia = new Noticia();
		return "";
	}

	public String editarUsuario() {
		try {
			DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();
//				System.out.println(noticiasAtt.getTitulo());
			daoGenerico.mergeAtts(usuario2);
			addMessage("Sucesso ao editar Usuário");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro ao editar Usuário");
		}
		noticia = new Noticia();
		return "";
	}

	public String salvarUsuario() {

		String img = "data:image/jpg;base64," + DatatypeConverter.printBase64Binary(this.getFile().getContents());
		try {
			DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();
			usuario2.setImagem(img);
			daoGenerico.inserir(usuario2);
			usuario2 = new Usuario();
			addMessage("Sucesso ao inserir Usuário");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addMessage("Erro ao inserir Usuário");
		}
		return "";
	}

	public void upload(FileUploadEvent event) {
		System.out.println("osk");
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

//		public void upload(FileUploadEvent imagem) {
//			String img = "data:image/jpg;base64,"+DatatypeConverter.printBase64Binary(imagem.getFile().getContents());
//			System.out.println(img);
//			System.out.println(usuario2.getImagem());
//			usuario2.setImagem(img);
//		}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UploadedFile getFile() {
		return file;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		usuario = (Usuario) session.getAttribute("usuarioLogado");
//			System.out.println(usuario);
//			System.out.println("USUaARIO LOPOST CRonss");
		if (usuario != null) {
			usuario.setStatus("USUARIONAOLOGADO");
		}
	}

}
