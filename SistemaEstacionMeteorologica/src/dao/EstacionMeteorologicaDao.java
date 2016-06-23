package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.EstacionMeteorologica;


public class EstacionMeteorologicaDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {

		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {

		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public void actualizar(EstacionMeteorologica objeto) throws HibernateException {

		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	public EstacionMeteorologica traerEstacionMeteorologica(int idEstacionMeteorologica) throws HibernateException {
		EstacionMeteorologica objeto = null;
		try {
			iniciaOperacion();
			objeto = (EstacionMeteorologica) session.get(EstacionMeteorologica.class, idEstacionMeteorologica);
			} finally {
				session.close();
				}
		return objeto;
		}
}
