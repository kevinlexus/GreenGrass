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
 * Home object for domain model class DmfOrg.
 * @see test1.DmfOrg
 * @author Hibernate Tools
 */
public class DmfOrgHome {

	private static final Log log = LogFactory.getLog(DmfOrgHome.class);

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

	public void persist(DmfOrg transientInstance) {
		log.debug("persisting DmfOrg instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DmfOrg instance) {
		log.debug("attaching dirty DmfOrg instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DmfOrg instance) {
		log.debug("attaching clean DmfOrg instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DmfOrg persistentInstance) {
		log.debug("deleting DmfOrg instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DmfOrg merge(DmfOrg detachedInstance) {
		log.debug("merging DmfOrg instance");
		try {
			DmfOrg result = (DmfOrg) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DmfOrg findById(test1.DmfOrgId id) {
		log.debug("getting DmfOrg instance with id: " + id);
		try {
			DmfOrg instance = (DmfOrg) sessionFactory.getCurrentSession().get(
					"test1.DmfOrg", id);
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

	public List<DmfOrg> findByExample(DmfOrg instance) {
		log.debug("finding DmfOrg instance by example");
		try {
			List<DmfOrg> results = (List<DmfOrg>) sessionFactory
					.getCurrentSession().createCriteria("test1.DmfOrg")
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
