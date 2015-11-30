package model.hibernate;

// Generated Nov 7, 2015 12:57:09 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ProductsInStorePrices.
 * @see model.hibernate.ProductsInStorePrices
 * @author Hibernate Tools
 */
public class ProductsInStorePricesHome {

	private static final Log log = LogFactory
			.getLog(ProductsInStorePricesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ProductsInStorePrices transientInstance) {
		log.debug("persisting ProductsInStorePrices instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductsInStorePrices instance) {
		log.debug("attaching dirty ProductsInStorePrices instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductsInStorePrices instance) {
		log.debug("attaching clean ProductsInStorePrices instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProductsInStorePrices persistentInstance) {
		log.debug("deleting ProductsInStorePrices instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductsInStorePrices merge(ProductsInStorePrices detachedInstance) {
		log.debug("merging ProductsInStorePrices instance");
		try {
			ProductsInStorePrices result = (ProductsInStorePrices) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductsInStorePrices findById(int id) {
		log.debug("getting ProductsInStorePrices instance with id: " + id);
		try {
			ProductsInStorePrices instance = (ProductsInStorePrices) sessionFactory
					.getCurrentSession().get(
							"model.hibernate.ProductsInStorePrices", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProductsInStorePrices instance) {
		log.debug("finding ProductsInStorePrices instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("model.hibernate.ProductsInStorePrices")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
