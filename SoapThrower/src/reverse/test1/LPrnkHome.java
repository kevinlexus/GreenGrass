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
 * Home object for domain model class LPrnk.
 * @see test1.LPrnk
 * @author Hibernate Tools
 */
public class LPrnkHome {

	private static final Log log = LogFactory.getLog(LPrnkHome.class);

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

	public void persist(LPrnk transientInstance) {
		log.debug("persisting LPrnk instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LPrnk instance) {
		log.debug("attaching dirty LPrnk instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LPrnk instance) {
		log.debug("attaching clean LPrnk instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LPrnk persistentInstance) {
		log.debug("deleting LPrnk instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LPrnk merge(LPrnk detachedInstance) {
		log.debug("merging LPrnk instance");
		try {
			LPrnk result = (LPrnk) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LPrnk findById(test1.LPrnkId id) {
		log.debug("getting LPrnk instance with id: " + id);
		try {
			LPrnk instance = (LPrnk) sessionFactory.getCurrentSession().get(
					"test1.LPrnk", id);
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

	public List<LPrnk> findByExample(LPrnk instance) {
		log.debug("finding LPrnk instance by example");
		try {
			List<LPrnk> results = (List<LPrnk>) sessionFactory
					.getCurrentSession().createCriteria("test1.LPrnk")
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
