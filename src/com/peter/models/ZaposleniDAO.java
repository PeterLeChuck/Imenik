package com.peter.models;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peter
 * Data Access Object that creates commands CREATE, DELETE, SELECT * to manipulate database, with help of Hibernate's function session.
 */
@Repository
@Transactional
public class ZaposleniDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @return
	 * Returns list of every record in table Zaposleni.
	 */
	@SuppressWarnings("unchecked")
	public List<Zaposleni> getAllZaposleni() {
		Session session = session();
		Query query = session.createSQLQuery("SELECT * FROM Zaposleni")
				.addEntity(Zaposleni.class);
		List<Zaposleni> zaposleniList = query.list();
		return zaposleniList;
	}

	/**
	 * @param id
	 * @return
	 * Returns a record from table Zaposleni with a given id.
	 */
	public Zaposleni findById(Long id) {
		Zaposleni zaposleni = (Zaposleni) session().load(Zaposleni.class, id);
		Hibernate.initialize(zaposleni);
		return zaposleni;
	}

	/**
	 * @param employee
	 * Create new record or update an existing one.
	 */
	public void create(Zaposleni employee) {
		Session session = session();
		session.saveOrUpdate(employee);
	}

	/**
	 * @param employee
	 * Delete a given record from Zaposleni.
	 */
	public void delete(Zaposleni employee) {
		session().delete(employee);
	}

	/**
	 * @param id
	 * Delete a record with a given id from Zaposleni.
	 */
	public void deleteById(Long id) {
		Session session = session();
		Zaposleni zaposleni = (Zaposleni) session.load(Zaposleni.class, id);
		session().delete(zaposleni);
	}
}
