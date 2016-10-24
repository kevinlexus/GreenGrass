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
 * Home object for domain model class AssignerNew.
 * @see test1.AssignerNew
 * @author Hibernate Tools
 */
public class AssignerNewHome {

	private static final Log log = LogFactory.getLog(AssignerNewHome.class);

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

	public void persist(AssignerNew transientInstance) {
		log.debug("persisting AssignerNew instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssignerNew instance) {
		log.debug("attaching dirty AssignerNew instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssignerNew instance) {
		log.debug("attaching clean AssignerNew instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssignerNew persistentInstance) {
		log.debug("deleting AssignerNew instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssignerNew merge(AssignerNew detachedInstance) {
		log.debug("merging AssignerNew instance");
		try {
			AssignerNew result = (AssignerNew) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssignerNew findById(test1.AssignerNewId id) {
		log.debug("getting AssignerNew instance with id: " + id);
		try {
			AssignerNew instance = (AssignerNew) sessionFactory
					.getCurrentSession().get("test1.AssignerNew", id);
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

	public List<AssignerNew> findByExample(AssignerNew instance) {
		log.debug("finding AssignerNew instance by example");
		try {
			List<AssignerNew> results = (List<AssignerNew>) sessionFactory
					.getCurrentSession().createCriteria("test1.AssignerNew")
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
