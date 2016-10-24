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
 * Home object for domain model class LskGuid.
 * @see test1.LskGuid
 * @author Hibernate Tools
 */
public class LskGuidHome {

	private static final Log log = LogFactory.getLog(LskGuidHome.class);

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

	public void persist(LskGuid transientInstance) {
		log.debug("persisting LskGuid instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LskGuid instance) {
		log.debug("attaching dirty LskGuid instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LskGuid instance) {
		log.debug("attaching clean LskGuid instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LskGuid persistentInstance) {
		log.debug("deleting LskGuid instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LskGuid merge(LskGuid detachedInstance) {
		log.debug("merging LskGuid instance");
		try {
			LskGuid result = (LskGuid) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LskGuid findById(test1.LskGuidId id) {
		log.debug("getting LskGuid instance with id: " + id);
		try {
			LskGuid instance = (LskGuid) sessionFactory.getCurrentSession()
					.get("test1.LskGuid", id);
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

	public List<LskGuid> findByExample(LskGuid instance) {
		log.debug("finding LskGuid instance by example");
		try {
			List<LskGuid> results = (List<LskGuid>) sessionFactory
					.getCurrentSession().createCriteria("test1.LskGuid")
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
