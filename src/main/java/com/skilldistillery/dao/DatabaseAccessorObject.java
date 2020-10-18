package com.skilldistillery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		Film film = null;
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT * FROM film \n" + "JOIN film_actor ON film_actor.film_id = film.id \n"
//					+ "JOIN actor ON film_actor.actor_id = actor.id \n" + "WHERE film.id = ?";
			String sql = "SELECT * FROM film join language on film.language_id = language.id where film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setLanguage(getLanguage(filmId));

				filmResult.close();
				stmt.close();
				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}
	

	@Override
	public Film findFilmByIDEdit(int filmId) {

		Film film = null;
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film \n" + "JOIN film_actor ON film_actor.film_id = film.id \n"
					+ "JOIN actor ON film_actor.actor_id = actor.id \n" + "WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setLanguage(getLanguage(filmId));

				filmResult.close();
				stmt.close();
				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}

	@Override
	public List<Film> findFilmBySearchWord(String keyword) {
		Film film = null;
		List<Film> filmsList = new ArrayList<>();
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.* " + "FROM film " + "WHERE film.title " + "LIKE ? OR film.description "
					+ "LIKE ?; ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				film = new Film();

				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmResult.getInt("id")));
				film.setLanguage(getLanguage(film.getId()));

				filmsList.add(film);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmsList;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		String sql = "SELECT * from actor WHERE actor.id = ?";
		if (actorId <= 0) {
			return null;
		}
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));

				actorResult.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorsList = new ArrayList<>();
		if (filmId <= 0) {
			return null;
		}
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM film \n"
					+ "JOIN film_actor ON film_actor.film_id = film.id \n"
					+ "JOIN actor ON film_actor.actor_id = actor.id \n" + "WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
//				Actor actor = new Actor(); 
				int id = actorResult.getInt("id");
				String firstName = actorResult.getString("first_name");
				String lastName = actorResult.getString("last_name");
				Actor actor = new Actor(id, firstName, lastName);
				actorsList.add(actor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actorsList;
	}

	@Override
	public String getLanguage(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		String sql = "SELECT language.name " + "FROM film " + "JOIN language " + "ON film.language_id=language.id "
				+ "WHERE film.id = ?";
		String language = "";

		String user = "student";
		String pass = "student";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				language = rs.getString("language.name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return language;

	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {
			String user = "student";
			String pass = "student";
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			// TODO MUST CHANGE BACK delete film.
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
					+ " VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
//					if (film.getActors() != null && film.getActors().size() > 0) {
//						sql = "INSERT INTO film_actor (actor_id, film_id) VALUES (?,?)";
//						stmt = conn.prepareStatement(sql);
//						for (Actor actor : film.getActors()) {
//							stmt.setInt(1, actor.getId());
//							stmt.setInt(2, newFilmId);
//							updateCount = stmt.executeUpdate();
//						}
//					}
				}
			} else {
				film = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			System.out.println("Error trying to rollback");

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.out.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	public Film deleteFilm(int filmIdDelete) {
		Connection conn = null;
		Film film = null;
		System.out.println(filmIdDelete);
		System.out.println(" 266");
		try {
			String user = "student";
			System.out.println(" 269");
			String pass = "student";
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			System.out.println(" 273");
			System.out.println(filmIdDelete);
			String sql = "DELETE FROM film WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmIdDelete);
			System.out.println(filmIdDelete);
			System.out.println(" 278");

			stmt.executeUpdate();
//			sql = "DELETE FROM film WHERE id = ?";
//			stmt.setInt(1, film.getId());
//			
//		      stmt.executeUpdate();
		      System.out.println(" 284");
		      
		      System.out.println("Record deleted successfully");
		      System.out.println(" 287");
		  	conn.commit(); 
		    } catch (SQLException e) {
		      e.printStackTrace();
			} // COMMIT TRANSACTION
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//			if (conn != null) {
//				try {
//					conn.rollback();
//				} catch (SQLException sqle2) {
//					System.err.println("Error trying to rollback");
//				}
//			}
		
//			return false;
		
		return film;
	}

	public boolean updateFilm(Film film) {
		Connection conn = null;
		try {
			String user = "student";
			String pass = "student";
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id =?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setInt(10, film.getId());

//			int updateCount = stmt.executeUpdate();
//			if (updateCount == 1) {
//				// Replace actor's film list
//				sql = "DELETE FROM film_actor WHERE actor_id = ?";
//				stmt = conn.prepareStatement(sql);
//				stmt.setInt(1, film.getId());
//				
//				
//				updateCount = stmt.executeUpdate();
//				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
//				stmt = conn.prepareStatement(sql);
//				for (Actor actor : film.getActors()) {
//					stmt.setInt(1, film.getId());
//					stmt.setInt(2, actor.getId());
//					updateCount = stmt.executeUpdate();
//				}
			stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
//			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

}
