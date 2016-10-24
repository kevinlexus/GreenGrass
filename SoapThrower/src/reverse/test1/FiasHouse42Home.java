package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FiasHouse42.
 * @see test1.FiasHouse42
 * @author Hibernate Tools
 */
public class FiasHouse42Home {

	private static final Log log = LogFactory.getLog(FiasHouse42Home.class);

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

	public void persist(FiasHouse42 transientInstance) {
		log.debug("persisting FiasHouse42 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FiasHouse42 instance) {
		log.debug("attaching dirty FiasHouse42 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FiasHouse42 instance) {
		log.debug("attaching clean FiasHouse42 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FiasHouse42 persistentInstance) {
		log.debug("deleting FiasHouse42 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FiasHouse42 merge(FiasHouse42 detachedInstance) {
		log.debug("merging FiasHouse42 instance");
		try {
			FiasHouse42 result = (FiasHouse42) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FiasHouse42 findById(test1.FiasHouse42Id id) {
		log.debug("getting FiasHouse42 instance with id: " + id);
		try {
			FiasHouse42 instance = (FiasHouse42) sessionFactory
					.getCurrentSession().get("test1.FiasHouse42", id);
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

	public List<FiasHouse42> findByExample(FiasHouse42 instance) {
		log.debug("finding FiasHouse42 instance by example");
		try {
			List<FiasHouse42> results = (List<FiasHouse42>) sessionFactory
					.getCurrentSession().createCriteria("test1.FiasHouse42")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
