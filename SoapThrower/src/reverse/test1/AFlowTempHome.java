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
 * Home object for domain model class AFlowTemp.
 * @see test1.AFlowTemp
 * @author Hibernate Tools
 */
public class AFlowTempHome {

	private static final Log log = LogFactory.getLog(AFlowTempHome.class);

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

	public void persist(AFlowTemp transientInstance) {
		log.debug("persisting AFlowTemp instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AFlowTemp instance) {
		log.debug("attaching dirty AFlowTemp instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AFlowTemp instance) {
		log.debug("attaching clean AFlowTemp instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AFlowTemp persistentInstance) {
		log.debug("deleting AFlowTemp instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AFlowTemp merge(AFlowTemp detachedInstance) {
		log.debug("merging AFlowTemp instance");
		try {
			AFlowTemp result = (AFlowTemp) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AFlowTemp findById(test1.AFlowTempId id) {
		log.debug("getting AFlowTemp instance with id: " + id);
		try {
			AFlowTemp instance = (AFlowTemp) sessionFactory.getCurrentSession()
					.get("test1.AFlowTemp", id);
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

	public List<AFlowTemp> findByExample(AFlowTemp instance) {
		log.debug("finding AFlowTemp instance by example");
		try {
			List<AFlowTemp> results = (List<AFlowTemp>) sessionFactory
					.getCurrentSession().createCriteria("test1.AFlowTemp")
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
