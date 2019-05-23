package data.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "albums")
@NamedQueries({
	@NamedQuery(name="findByTitle", query="from Album where title = :titleVar")
})
public class Album {
	@Id
	private int id;
	@Column(name = "title")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "artist_id")
	private Artist artist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album(int id, String title, Artist artist) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artist=" + artist + "]";
	}

}
