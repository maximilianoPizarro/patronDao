package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Medicion;
import datos.Provincia;
import funciones.Funciones;

public class MedicionDao {

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

	public Medicion traerMedicion(int idMedicion) throws HibernateException {
		Medicion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Medicion where idMedicion =:idMedicion";
			objeto = (Medicion) session.createQuery(hql)
					.setParameter("idMedicion", (int) idMedicion)
					.uniqueResult();
			Hibernate.initialize(objeto.getEstacion());
			Hibernate.initialize(objeto.getProvincia());
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}

	
	@SuppressWarnings("unchecked")
	public List<Medicion> traerMedicion(Provincia provincia, Calendar fechaInicial, Calendar fechaFinal)
			throws HibernateException {
		List<Medicion> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Medicion where idProvincia =:idProvincia AND fecha BETWEEN :ffechaInicial AND :ffechaFinal";
			lista = session.createQuery(hql).setCalendar("ffechaInicial", fechaInicial).setCalendar("ffechaFinal", fechaFinal)
					.setParameter("idProvincia", provincia.getIdProvincia())
					.list();
			for (Medicion m : lista) {
				Hibernate.initialize(m.getProvincia());
				Hibernate.initialize(m.getEstacion());
			}
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Medicion> traerMedicion(Provincia provincia, Calendar fecha)
			throws HibernateException {
		List<Medicion> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Medicion where idProvincia =:idProvincia and fecha =:ffecha";
			lista = session.createQuery(hql).setCalendar("ffecha", fecha)
					.setParameter("idProvincia", provincia.getIdProvincia())
					.list();
			for (Medicion m : lista) {
				Hibernate.initialize(m.getProvincia());
				Hibernate.initialize(m.getEstacion());
			}

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Medicion> traerMedicion(Calendar fecha)
			throws HibernateException {
		List<Medicion> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Medicion where fecha =:ffecha";
			lista = session.createQuery(hql).setCalendar("ffecha", fecha)
					.list();
			for (Medicion m : lista) {
				Hibernate.initialize(m.getProvincia());
				Hibernate.initialize(m.getEstacion());
			}
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Medicion> traerMedicion(Calendar fechaInicial, Calendar fechaFinal)
			throws HibernateException {
		List<Medicion> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Medicion where fecha BETWEEN :ffechaInicial AND :ffechaFinal";
			lista = session.createQuery(hql).setCalendar("ffechaInicial", fechaInicial).setCalendar("ffechaFinal", fechaFinal)
					.list();
			for (Medicion m : lista) {
				Hibernate.initialize(m.getProvincia());
				Hibernate.initialize(m.getEstacion());
			}
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return lista;
	}	
}
