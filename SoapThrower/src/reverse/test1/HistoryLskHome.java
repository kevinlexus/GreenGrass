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
 * Home object for domain model class HistoryLsk.
 * @see test1.HistoryLsk
 * @author Hibernate Tools
 */
public class HistoryLskHome {

	private static final Log log = LogFactory.getLog(HistoryLskHome.class);

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

	public void persist(HistoryLsk transientInstance) {
		log.debug("persisting HistoryLsk instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HistoryLsk instance) {
		log.debug("attaching dirty HistoryLsk instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HistoryLsk instance) {
		log.debug("attaching clean HistoryLsk instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HistoryLsk persistentInstance) {
		log.debug("deleting HistoryLsk instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistoryLsk merge(HistoryLsk detachedInstance) {
		log.debug("merging HistoryLsk instance");
		try {
			HistoryLsk result = (HistoryLsk) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HistoryLsk findById(test1.HistoryLskId id) {
		log.debug("getting HistoryLsk instance with id: " + id);
		try {
			HistoryLsk instance = (HistoryLsk) sessionFactory
					.getCurrentSession().get("test1.HistoryLsk", id);
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

	public List<HistoryLsk> findByExample(HistoryLsk instance) {
		log.debug("finding HistoryLsk instance by example");
		try {
			List<HistoryLsk> results = (List<HistoryLsk>) sessionFactory
					.getCurrentSession().createCriteria("test1.HistoryLsk")
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
