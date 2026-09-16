package com.movieticket.HibernateCrudOperation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDAO {

    // =========================
    // CREATE
    // =========================
    public void saveMovie(Movie movie) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(movie);

            transaction.commit();

            System.out.println("Movie inserted successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =========================
    // READ - By ID
    // =========================
    public Movie getMovie(int id) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            Movie movie = session.get(Movie.class, id);

            return movie;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }


    // =========================
    // READ - All Movies
    // =========================
    public List<Movie> getAllMovies() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<Movie> movies = session
                    .createQuery("from Movie", Movie.class)
                    .getResultList();

            return movies;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }


    // =========================
    // UPDATE
    // =========================
    public void updateMovie(Movie movie) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(movie);

            transaction.commit();

            System.out.println("Movie updated successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // =========================
    // DELETE
    // =========================
    public void deleteMovie(int id) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Movie movie = session.get(Movie.class, id);

            if (movie != null) {

                session.remove(movie);

                System.out.println("Movie deleted successfully!");

            } else {

                System.out.println("Movie not found!");

            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}