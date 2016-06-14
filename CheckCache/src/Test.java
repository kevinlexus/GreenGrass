import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		
  	    Master k2=(Master) sess.get(Master.class, 1027303);
		
  		System.out.println(k2.getDetail());
 		
  	    for (Detail t : k2.getDetail()) {
			 System.out.println("Tar="+t.getN1());
		}
	
		Statistics stats = sf.getStatistics();
		printStats(stats);
		
		System.out.println("Complete!");
		
	}

	
    private static void printStats(Statistics stats) {
        System.out.println("***** " + " *****");
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
