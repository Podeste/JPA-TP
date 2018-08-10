package formation.dao;


import java.util.List;

	public interface IDAO<T,PK> {
		List<T> findAll();
		T findById(PK id);
		T save(T entity);
		void delete(T entity);
		void deleteById(PK id);
	}


