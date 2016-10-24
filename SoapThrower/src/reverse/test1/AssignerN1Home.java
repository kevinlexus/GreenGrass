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
 * Home object for domain model class AssignerN1.
 * @see test1.AssignerN1
 * @author Hibernate Tools
 */
public class AssignerN1Home {

	private static final Log log = LogFactory.getLog(AssignerN1Home.class);

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

	public void persist(AssignerN1 transientInstance) {
		log.debug("persisting AssignerN1 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssignerN1 instance) {
		log.debug("attaching dirty AssignerN1 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssignerN1 instance) {
		log.debug("attaching clean AssignerN1 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssignerN1 persistentInstance) {
		log.debug("deleting AssignerN1 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssignerN1 merge(AssignerN1 detachedInstance) {
		log.debug("merging AssignerN1 instance");
		try {
			AssignerN1 result = (AssignerN1) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssignerN1 findById(test1.AssignerN1Id id) {
		log.debug("getting AssignerN1 instance with id: " + id);
		try {
			AssignerN1 instance = (AssignerN1) sessionFactory
					.getCurrentSession().get("test1.AssignerN1", id);
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

	public List<AssignerN1> findByExample(AssignerN1 instance) {
		log.debug("finding AssignerN1 instance by example");
		try {
			List<AssignerN1> results = (List<AssignerN1>) sessionFactory
					.getCurrentSession().createCriteria("test1.AssignerN1")
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
