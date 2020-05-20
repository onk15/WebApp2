package io.github.mat3e;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class HibernateUtil {
        private static final SessionFactory sessionFactory = buildSessionFactory();

        static void close()
        {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

        private static SessionFactory buildSessionFactory() {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try
            {
                return new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }
            catch (Exception e)
            {
                StandardServiceRegistryBuilder.destroy(registry);
                throw e;
            }
        }

        private HibernateUtil()
        {

        }

    }


