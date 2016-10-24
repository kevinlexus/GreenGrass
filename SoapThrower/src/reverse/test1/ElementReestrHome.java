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
 * Home object for domain model class ElementReestr.
 * @see test1.ElementReestr
 * @author Hibernate Tools
 */
public class ElementReestrHome {

	private static final Log log = LogFactory.getLog(ElementReestrHome.class);

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

	public void persist(ElementReestr transientInstance) {
		log.debug("persisting ElementReestr instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ElementReestr instance) {
		log.debug("attaching dirty ElementReestr instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ElementReestr instance) {
		log.debug("attaching clean ElementReestr instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ElementReestr persistentInstance) {
		log.debug("deleting ElementReestr instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ElementReestr merge(ElementReestr detachedInstance) {
		log.debug("merging ElementReestr instance");
		try {
			ElementReestr result = (ElementReestr) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ElementReestr findById(test1.ElementReestrId id) {
		log.debug("getting ElementReestr instance with id: " + id);
		try {
			ElementReestr instance = (ElementReestr) sessionFactory
					.getCurrentSession().get("test1.ElementReestr", id);
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

	public List<ElementReestr> findByExample(ElementReestr instance) {
		log.debug("finding ElementReestr instance by example");
		try {
			List<ElementReestr> results = (List<ElementReestr>) sessionFactory
					.getCurrentSession().createCriteria("test1.ElementReestr")
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
