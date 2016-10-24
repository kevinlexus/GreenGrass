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
 * Home object for domain model class TempLskKw.
 * @see test1.TempLskKw
 * @author Hibernate Tools
 */
public class TempLskKwHome {

	private static final Log log = LogFactory.getLog(TempLskKwHome.class);

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

	public void persist(TempLskKw transientInstance) {
		log.debug("persisting TempLskKw instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TempLskKw instance) {
		log.debug("attaching dirty TempLskKw instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TempLskKw instance) {
		log.debug("attaching clean TempLskKw instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TempLskKw persistentInstance) {
		log.debug("deleting TempLskKw instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TempLskKw merge(TempLskKw detachedInstance) {
		log.debug("merging TempLskKw instance");
		try {
			TempLskKw result = (TempLskKw) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TempLskKw findById(test1.TempLskKwId id) {
		log.debug("getting TempLskKw instance with id: " + id);
		try {
			TempLskKw instance = (TempLskKw) sessionFactory.getCurrentSession()
					.get("test1.TempLskKw", id);
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

	public List<TempLskKw> findByExample(TempLskKw instance) {
		log.debug("finding TempLskKw instance by example");
		try {
			List<TempLskKw> results = (List<TempLskKw>) sessionFactory
					.getCurrentSession().createCriteria("test1.TempLskKw")
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
