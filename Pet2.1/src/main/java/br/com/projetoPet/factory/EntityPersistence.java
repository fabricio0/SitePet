package br.com.projetoPet.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityPersistence {
	private static final String nomePersistence = "ProjetoSitePet";
	private static EntityManagerFactory entityManagerFactory = null;
	//Método estatico passa aqui
	static {
		CriaEntityManager();
	}

	// Método para criação da conexão 
	//retorna uma EntityManager
	public static EntityManager CriaEntityManager() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory(nomePersistence);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return entityManagerFactory.createEntityManager();
	}
	
	public static Object buscarPorId(Object id) {
		return entityManagerFactory.getPersistenceUnitUtil().getIdentifier(id);
	}
	//Busca por id
	public static Object buscaId(Long id) {
		return entityManagerFactory.getPersistenceUnitUtil().getIdentifier(id);
	}
	
	
	
	
}
