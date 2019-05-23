package data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import data.domain.Artist;

@Repository
public class ArtistRepository {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Artist> getArtists() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(Artist.class).list();
	}
}
