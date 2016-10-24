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
 * Home object for domain model class TempAFlowDeb.
 * @see test1.TempAFlowDeb
 * @author Hibernate Tools
 */
public class TempAFlowDebHome {

	private static final Log log = LogFactory.getLog(TempAFlowDebHome.class);

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

	public void persist(TempAFlowDeb transientInstance) {
		log.debug("persisting TempAFlowDeb instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TempAFlowDeb instance) {
		log.debug("attaching dirty TempAFlowDeb instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TempAFlowDeb instance) {
		log.debug("attaching clean TempAFlowDeb instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TempAFlowDeb persistentInstance) {
		log.debug("deleting TempAFlowDeb instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TempAFlowDeb merge(TempAFlowDeb detachedInstance) {
		log.debug("merging TempAFlowDeb instance");
		try {
			TempAFlowDeb result = (TempAFlowDeb) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TempAFlowDeb findById(test1.TempAFlowDebId id) {
		log.debug("getting TempAFlowDeb instance with id: " + id);
		try {
			TempAFlowDeb instance = (TempAFlowDeb) sessionFactory
					.getCurrentSession().get("test1.TempAFlowDeb", id);
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

	public List<TempAFlowDeb> findByExample(TempAFlowDeb instance) {
		log.debug("finding TempAFlowDeb instance by example");
		try {
			List<TempAFlowDeb> results = (List<TempAFlowDeb>) sessionFactory
					.getCurrentSession().createCriteria("test1.TempAFlowDeb")
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
