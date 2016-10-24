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
 * Home object for domain model class FiasAddrobj.
 * @see test1.FiasAddrobj
 * @author Hibernate Tools
 */
public class FiasAddrobjHome {

	private static final Log log = LogFactory.getLog(FiasAddrobjHome.class);

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

	public void persist(FiasAddrobj transientInstance) {
		log.debug("persisting FiasAddrobj instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FiasAddrobj instance) {
		log.debug("attaching dirty FiasAddrobj instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FiasAddrobj instance) {
		log.debug("attaching clean FiasAddrobj instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FiasAddrobj persistentInstance) {
		log.debug("deleting FiasAddrobj instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FiasAddrobj merge(FiasAddrobj detachedInstance) {
		log.debug("merging FiasAddrobj instance");
		try {
			FiasAddrobj result = (FiasAddrobj) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FiasAddrobj findById(test1.FiasAddrobjId id) {
		log.debug("getting FiasAddrobj instance with id: " + id);
		try {
			FiasAddrobj instance = (FiasAddrobj) sessionFactory
					.getCurrentSession().get("test1.FiasAddrobj", id);
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

	public List<FiasAddrobj> findByExample(FiasAddrobj instance) {
		log.debug("finding FiasAddrobj instance by example");
		try {
			List<FiasAddrobj> results = (List<FiasAddrobj>) sessionFactory
					.getCurrentSession().createCriteria("test1.FiasAddrobj")
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
