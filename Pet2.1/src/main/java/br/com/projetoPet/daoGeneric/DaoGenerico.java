package br.com.projetoPet.daoGeneric;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.projetoPet.factory.EntityPersistence;
import br.com.projetoPet.util.Usuario;

public class DaoGenerico<T> {
	
	EntityManager entityManager = null;
	
	public void inserir(T t) {
		entityManager = EntityPersistence.CriaEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(t);
//			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			entityTransaction.rollback();
		}finally {
			if (entityManager.isOpen()) 
				entityManager.close();
		}
	}

	public ArrayList<T> buscarTodos(String entidade, Class<T> Entidade) {
		try {
			entityManager = EntityPersistence.CriaEntityManager();
			TypedQuery<T> q = entityManager.createQuery("Select a From " + entidade +  " a", Entidade);
//			q.setParameter("entidade", entidade);
			return (ArrayList<T>) q.getResultList();
		}catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
			return null;
		}finally {
			if (entityManager.isOpen()) 
				entityManager.close();
		}
	}

	public Object buscarUsuario(Usuario usuario) {
		Query q = null;
		Object object = null;
		try {
			String query = "select t from Usuario t where t.email = :email and senha = :senha";
			entityManager = EntityPersistence.CriaEntityManager();
			q = entityManager.createQuery(query);
			q.setParameter("email", usuario.getEmail());
			q.setParameter("senha", usuario.getSenha());
			object = q.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			if (entityManager.isOpen()) 
				entityManager.close();
		}
		return object;
	}
	public EntityManager getEntityManager() {
		return EntityPersistence.CriaEntityManager();
	}

	

	public Object buscaId(Class<T> class1, Long id) {
		Object object = null;
		try {
			entityManager = EntityPersistence.CriaEntityManager();
			object = entityManager.getReference(class1, id);
			return object;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
//			if (entityManager.isOpen()) 
//				entityManager.close();
		}
	}

	public void mergeAtts(T t) {
		// TODO Auto-generated method stub
		try {
			entityManager = EntityPersistence.CriaEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			t = entityManager.merge(t);

			entityManager.persist(t);
			entityTransaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (entityManager.isOpen()) 
				entityManager.close();
		}		
	}
}


