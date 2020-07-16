package br.com.projetoPet.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.projetoPet.daoGeneric.DaoGenerico;
import br.com.projetoPet.dataLazy.LazyDataTableUserPessoa;
import br.com.projetoPet.util.Atividade;
import br.com.projetoPet.util.Noticia;
import br.com.projetoPet.util.Usuario;

@ViewScoped
@ManagedBean(name = "beanView")
public class beanView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Usuario> usuarios;
	LazyDataTableUserPessoa<Noticia> noticias = new LazyDataTableUserPessoa<Noticia>();
	ArrayList<Atividade> atividades;
	Usuario usuario = new Usuario();
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public LazyDataTableUserPessoa<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(LazyDataTableUserPessoa<Noticia> noticias) {
		this.noticias = noticias;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

	@PostConstruct
	private void init() {
		if (noticias == null) {
			noticias.load(0, 5, null, null,null);
		}
		if (usuarios == null && atividades == null) {
			DaoGenerico<Usuario> daogenericoUsuario = new DaoGenerico<Usuario>();
			usuarios = daogenericoUsuario.buscarTodos("Usuario", Usuario.class);
			DaoGenerico<Atividade> daogenericoAtividade = new DaoGenerico<Atividade>();
			atividades = daogenericoAtividade.buscarTodos("Atividade", Atividade.class);
		}
//		for (Usuario u : usuarios) {
//			System.out.println(u.getNome());
//		}

	}

//	public String listarUser() {
//		if (usuarios == null) {
//			DaoGenerico<Usuario> daogenericoUsuario = new DaoGenerico<Usuario>();
//			usuarios = daogenericoUsuario.buscarTodos("Usuario", Usuario.class);
//		}
//		return "";
//	}

}
