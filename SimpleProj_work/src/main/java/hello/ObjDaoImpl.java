package hello;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import test.HibernateUtil;
import hello.ObjDao;
import hello.PojoRow;

public class ObjDaoImpl implements ObjDao {
    
	static Session sess;
	
	public static Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
    public void addProduct(PojoRow prod) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(prod);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateProduct(PojoRow prod) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(prod);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public List<PojoRow> getAllProduct() throws SQLException {
            Session session = null;
            List<PojoRow> prods = new ArrayList<PojoRow>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                prods = session.createCriteria(PojoRow.class).list();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return prods;
      }

  /*    public void deleteProduct(PojoProduct prod) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(prod);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  */
      
      
      public void deleteProduct(PojoRow prod) throws SQLException {
    	  sess = getSession();
          try {
              sess = HibernateUtil.getSessionFactory().openSession();
              sess.beginTransaction();
              sess.delete(prod);
              sess.getTransaction().commit();
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
          } finally {
              if (sess != null && sess.isOpen()) {
                  sess.close();
              }
          }
      
      
      
      
      }    
}