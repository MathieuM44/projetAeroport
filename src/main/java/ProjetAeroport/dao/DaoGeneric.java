package ProjetAeroport.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
<<<<<<< HEAD

=======
	
>>>>>>> 1e8269b0bc8d5bb3f87c59b9c856b3da0e66982c
	void create(T obj);

	T findByKey(K key);

	T update(T obj);
<<<<<<< HEAD

=======
	
>>>>>>> 1e8269b0bc8d5bb3f87c59b9c856b3da0e66982c
	void delete(T obj);

	void deleteByKey(K key);

	List<T> findAll();
}
