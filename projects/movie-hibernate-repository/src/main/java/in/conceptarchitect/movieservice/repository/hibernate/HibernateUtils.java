package in.conceptarchitect.movieservice.repository.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                LoggerFactory.logger(HibernateUtils.class).error(e);
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }


    public static void transact(SessionCommand command) {
    	Session session=null;
    	Transaction transaction=null;
    	try {
    		session=getSessionFactory().openSession();
    		transaction=session.beginTransaction();
    		command.execute(session);
    		transaction.commit();
    		
    	}catch(Exception ex) {
    		LoggerFactory.logger(HibernateUtils.class).error(ex);
    		if(transaction!=null)
    			transaction.rollback();
    	}finally {
    		if(session!=null)
    			session.close();
    	}
    }
    
    
    public static <T> List<T> query(String query, Class<T>cls){
    	Session session=getSessionFactory().openSession();
    	return session.createQuery(query,cls).list();
    }

}