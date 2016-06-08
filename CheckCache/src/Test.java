import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import com.ric.bill.model.bs.Lst;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		for (int a=1401; a<=1452; a++) {
			Lst lst = (Lst) sess.load(Lst.class, a);
			System.out.println(lst.getName());
		}
		for (int a=1401; a<=1452; a++) {
			Lst lst = (Lst) sess.load(Lst.class, a);
			System.out.println(lst.getName());
		}
		Statistics stats = sf.getStatistics();
		printStats(stats, 0);
		
		sess.getTransaction().commit();
		
		System.out.println("Complete!");
		
	}

	
    private static void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("Second Level Miss Count="
                        + stats
                                .getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }	
}
