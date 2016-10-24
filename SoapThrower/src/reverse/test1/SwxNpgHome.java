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
 * Home object for domain model class SwxNpg.
 * @see test1.SwxNpg
 * @author Hibernate Tools
 */
public class SwxNpgHome {

	private static final Log log = LogFactory.getLog(SwxNpgHome.class);

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

	public void persist(SwxNpg transientInstance) {
		log.debug("persisting SwxNpg instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SwxNpg instance) {
		log.debug("attaching dirty SwxNpg instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SwxNpg instance) {
		log.debug("attaching clean SwxNpg instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SwxNpg persistentInstance) {
		log.debug("deleting SwxNpg instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SwxNpg merge(SwxNpg detachedInstance) {
		log.debug("merging SwxNpg instance");
		try {
			SwxNpg result = (SwxNpg) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SwxNpg findById(test1.SwxNpgId id) {
		log.debug("getting SwxNpg instance with id: " + id);
		try {
			SwxNpg instance = (SwxNpg) sessionFactory.getCurrentSession().get(
					"test1.SwxNpg", id);
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

	public List<SwxNpg> findByExample(SwxNpg instance) {
		log.debug("finding SwxNpg instance by example");
		try {
			List<SwxNpg> results = (List<SwxNpg>) sessionFactory
					.getCurrentSession().createCriteria("test1.SwxNpg")
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
