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
 * Home object for domain model class LKartweb.
 * @see test1.LKartweb
 * @author Hibernate Tools
 */
public class LKartwebHome {

	private static final Log log = LogFactory.getLog(LKartwebHome.class);

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

	public void persist(LKartweb transientInstance) {
		log.debug("persisting LKartweb instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LKartweb instance) {
		log.debug("attaching dirty LKartweb instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LKartweb instance) {
		log.debug("attaching clean LKartweb instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LKartweb persistentInstance) {
		log.debug("deleting LKartweb instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LKartweb merge(LKartweb detachedInstance) {
		log.debug("merging LKartweb instance");
		try {
			LKartweb result = (LKartweb) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LKartweb findById(test1.LKartwebId id) {
		log.debug("getting LKartweb instance with id: " + id);
		try {
			LKartweb instance = (LKartweb) sessionFactory.getCurrentSession()
					.get("test1.LKartweb", id);
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

	public List<LKartweb> findByExample(LKartweb instance) {
		log.debug("finding LKartweb instance by example");
		try {
			List<LKartweb> results = (List<LKartweb>) sessionFactory
					.getCurrentSession().createCriteria("test1.LKartweb")
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
