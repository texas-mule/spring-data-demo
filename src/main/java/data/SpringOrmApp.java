package data;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import data.repository.ArtistRepository;
import data.repository.SpringDataConfig;

public class SpringOrmApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
		ArtistRepository ar = context.getBean("artistRepository", ArtistRepository.class);
		System.out.println(ar.getArtists());
		context.close();
	}

}
