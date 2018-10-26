package ProjetAeroport.dao;

import java.util.List;

<<<<<<< HEAD
public interface DaoGeneric<T, K> {
	void create(T obj);

	T findByKey(K key);

	T update(T obj);

=======
public interface DaoGeneric<T,K> {

	void create(T obj);		
	
	T findByKey(K key);		
	
	T update(T obj);
	
>>>>>>> b92c361a365e36d1dd6eab157519b989347db0d2
	void delete(T obj);
	
	void deleteByKey(K key);
	
	List<T> findAll();
}
