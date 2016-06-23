package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Medicion;
import datos.Provincia;

public class ProvinciaDao {
	
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
		}
		
		private void manejaExcepcion(HibernateException he) throws HibernateException {
			
			tx.rollback();
			throw new HibernateException("ERROR en la capa de acceso a datos", he);
			}
		
		
		public Provincia traerProvincia(int idProvincia) throws HibernateException {
			Provincia objeto = null;
			try {
				iniciaOperacion();
				String hql="from Provincia where idProvincia =:idProvincia";
				objeto=(Provincia) session.createQuery(hql).setParameter("idProvincia", (int)idProvincia).uniqueResult();
				Hibernate.initialize(objeto.getMediciones());
		
			}catch (HibernateException he) {
				manejaExcepcion(he);
				throw he;
			} finally {
					session.close();
					}
			return objeto;
			}

		}
