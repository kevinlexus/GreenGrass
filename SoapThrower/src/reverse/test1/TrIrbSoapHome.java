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
 * Home object for domain model class TrIrbSoap.
 * @see test1.TrIrbSoap
 * @author Hibernate Tools
 */
public class TrIrbSoapHome {

	private static final Log log = LogFactory.getLog(TrIrbSoapHome.class);

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

	public void persist(TrIrbSoap transientInstance) {
		log.debug("persisting TrIrbSoap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrIrbSoap instance) {
		log.debug("attaching dirty TrIrbSoap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrIrbSoap instance) {
		log.debug("attaching clean TrIrbSoap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrIrbSoap persistentInstance) {
		log.debug("deleting TrIrbSoap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrIrbSoap merge(TrIrbSoap detachedInstance) {
		log.debug("merging TrIrbSoap instance");
		try {
			TrIrbSoap result = (TrIrbSoap) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrIrbSoap findById(test1.TrIrbSoapId id) {
		log.debug("getting TrIrbSoap instance with id: " + id);
		try {
			TrIrbSoap instance = (TrIrbSoap) sessionFactory.getCurrentSession()
					.get("test1.TrIrbSoap", id);
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

	public List<TrIrbSoap> findByExample(TrIrbSoap instance) {
		log.debug("finding TrIrbSoap instance by example");
		try {
			List<TrIrbSoap> results = (List<TrIrbSoap>) sessionFactory
					.getCurrentSession().createCriteria("test1.TrIrbSoap")
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
