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
 * Home object for domain model class ElementDataBlob.
 * @see test1.ElementDataBlob
 * @author Hibernate Tools
 */
public class ElementDataBlobHome {

	private static final Log log = LogFactory.getLog(ElementDataBlobHome.class);

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

	public void persist(ElementDataBlob transientInstance) {
		log.debug("persisting ElementDataBlob instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ElementDataBlob instance) {
		log.debug("attaching dirty ElementDataBlob instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ElementDataBlob instance) {
		log.debug("attaching clean ElementDataBlob instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ElementDataBlob persistentInstance) {
		log.debug("deleting ElementDataBlob instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ElementDataBlob merge(ElementDataBlob detachedInstance) {
		log.debug("merging ElementDataBlob instance");
		try {
			ElementDataBlob result = (ElementDataBlob) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ElementDataBlob findById(test1.ElementDataBlobId id) {
		log.debug("getting ElementDataBlob instance with id: " + id);
		try {
			ElementDataBlob instance = (ElementDataBlob) sessionFactory
					.getCurrentSession().get("test1.ElementDataBlob", id);
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

	public List<ElementDataBlob> findByExample(ElementDataBlob instance) {
		log.debug("finding ElementDataBlob instance by example");
		try {
			List<ElementDataBlob> results = (List<ElementDataBlob>) sessionFactory
					.getCurrentSession()
					.createCriteria("test1.ElementDataBlob")
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
