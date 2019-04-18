package main.java.original;

public class Rental {
	private Movie _movie; // Ó°Æ¬
	private int _daysRented; // ×âÆÚ

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
}