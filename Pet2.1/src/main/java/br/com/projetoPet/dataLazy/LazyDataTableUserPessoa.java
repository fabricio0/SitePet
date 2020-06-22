package br.com.projetoPet.dataLazy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.projetoPet.daoGeneric.DaoGenerico;
import br.com.projetoPet.util.Noticia;

public class LazyDataTableUserPessoa<T> extends LazyDataModel<Noticia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DaoGenerico<Noticia> daoGenerico = new DaoGenerico<Noticia>();
	
	public List<Noticia> noticias = new ArrayList<Noticia>();
	
	private String sql = " from Noticia";
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		// TODO Auto-generated method stub
		
		
		noticias = (List<Noticia>) daoGenerico.getEntityManager()
				.createQuery(getSql()).setFirstResult(first)
				.setMaxResults(pageSize).getResultList();
		sql = " from Noticia";
		
		setPageSize(pageSize);
		int qtdRegistro = Integer.parseInt(daoGenerico.getEntityManager()
				.createQuery("select count(1) from Noticia").getSingleResult().toString());
		setRowCount(qtdRegistro);
		return noticias;
	}
	public String getSql() {
		return sql;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	
	public void pesquisa(String campoPersquisa) {
		sql += " where nome like '%" + campoPersquisa+ "%'";
	}
}
