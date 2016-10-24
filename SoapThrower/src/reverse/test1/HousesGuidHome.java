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
 * Home object for domain model class HousesGuid.
 * @see test1.HousesGuid
 * @author Hibernate Tools
 */
public class HousesGuidHome {

	private static final Log log = LogFactory.getLog(HousesGuidHome.class);

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

	public void persist(HousesGuid transientInstance) {
		log.debug("persisting HousesGuid instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HousesGuid instance) {
		log.debug("attaching dirty HousesGuid instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HousesGuid instance) {
		log.debug("attaching clean HousesGuid instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HousesGuid persistentInstance) {
		log.debug("deleting HousesGuid instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HousesGuid merge(HousesGuid detachedInstance) {
		log.debug("merging HousesGuid instance");
		try {
			HousesGuid result = (HousesGuid) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HousesGuid findById(test1.HousesGuidId id) {
		log.debug("getting HousesGuid instance with id: " + id);
		try {
			HousesGuid instance = (HousesGuid) sessionFactory
					.getCurrentSession().get("test1.HousesGuid", id);
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

	public List<HousesGuid> findByExample(HousesGuid instance) {
		log.debug("finding HousesGuid instance by example");
		try {
			List<HousesGuid> results = (List<HousesGuid>) sessionFactory
					.getCurrentSession().createCriteria("test1.HousesGuid")
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
