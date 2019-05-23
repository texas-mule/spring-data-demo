//package data;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
//
//import data.domain.Album;
//import data.domain.Artist;
//
//public class HibernateApp {
//
//	public static void main(String[] args) {
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//
//		SessionFactory sf = configuration.buildSessionFactory(ssrb.build());
//
//		Session session = sf.openSession();
//
//		session.beginTransaction();
//		List<Artist> artists = session.createCriteria(Artist.class).list();
//		System.out.println(artists.get(1));
//		artists.get(1).setName("Deny");
//		session.save(artists.get(1));
//		System.out.println(artists);
//		System.out.println(session.get(Artist.class, 3));
//		System.out.println(session.createCriteria(Artist.class).add(Restrictions.between("id", 5, 15))
//				.addOrder(Order.desc("name")).list());
//		System.out.println(session.createQuery("from Artist").list());
//		session.getTransaction().commit();
//		session.close();
//
//		Session albumSession = sf.openSession();
//		System.out.println(albumSession.createCriteria(Album.class).list());
//		System.out.println(albumSession.getNamedQuery("findByTitle")
//				.setString("titleVar", "Balls to the Wall").list());
//		albumSession.close();
//		sf.close();
//	}
//
//}
