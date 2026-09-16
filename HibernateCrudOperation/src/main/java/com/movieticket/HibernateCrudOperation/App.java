package com.movieticket.HibernateCrudOperation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        MovieDAO dao = new MovieDAO();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       MOVIE TICKET SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Movie");
            System.out.println("2. Show Movie By ID");
            System.out.println("3. Show All Movies");
            System.out.println("4. Update Movie");
            System.out.println("5. Delete Movie");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            // ================= ADD MOVIE =================
            if (choice == 1) {

                System.out.println();
                System.out.println("========== ADD MOVIE ==========");

                System.out.print("Enter movie title: ");
                String title = sc.nextLine();

                System.out.print("Enter description: ");
                String description = sc.nextLine();

                System.out.print("Enter genre: ");
                String genre = sc.nextLine();

                System.out.print("Enter duration (minutes): ");
                int duration = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter language: ");
                String language = sc.nextLine();

                System.out.print("Enter release date (YYYY-MM-DD): ");
                String date = sc.nextLine().trim();

                LocalDate releaseDate = LocalDate.parse(date);

                System.out.print("Enter status (ACTIVE/INACTIVE): ");
                String status = sc.nextLine();

                Movie movie = new Movie(
                        title,
                        description,
                        genre,
                        duration,
                        language,
                        releaseDate,
                        status
                );

                dao.saveMovie(movie);

                System.out.println();
                System.out.println("Movie ID: " + movie.getMovieId());
            }

            // ================= FIND MOVIE =================
            else if (choice == 2) {

                System.out.println();
                System.out.println("========== FIND MOVIE ==========");

                System.out.print("Enter movie ID: ");
                int id = sc.nextInt();

                Movie movie = dao.getMovie(id);

                if (movie != null) {

                    System.out.println();
                    System.out.println("Movie Found:");
                    System.out.println(movie);

                } else {

                    System.out.println("Movie not found!");
                }
            }

            // ================= SHOW ALL MOVIES =================
            else if (choice == 3) {

                System.out.println();
                System.out.println("========== ALL MOVIES ==========");

                List<Movie> movies = dao.getAllMovies();

                if (movies != null && !movies.isEmpty()) {

                    for (Movie movie : movies) {
                        System.out.println(movie);
                    }

                } else {

                    System.out.println("No movies found!");
                }
            }

            // ================= UPDATE MOVIE =================
            else if (choice == 4) {

                System.out.println();
                System.out.println("========== UPDATE MOVIE ==========");

                System.out.print("Enter movie ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                Movie movie = dao.getMovie(id);

                if (movie != null) {

                    System.out.println();
                    System.out.println("Current Movie:");
                    System.out.println(movie);

                    System.out.println();

                    System.out.print("Enter new title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter new description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter new genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Enter new duration: ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new language: ");
                    String language = sc.nextLine();

                    System.out.print("Enter new release date (YYYY-MM-DD): ");
                    String date = sc.nextLine().trim();

                    LocalDate releaseDate = LocalDate.parse(date);

                    System.out.print("Enter new status (ACTIVE/INACTIVE): ");
                    String status = sc.nextLine();

                    // Set new values
                    movie.setTitle(title);
                    movie.setDescription(description);
                    movie.setGenre(genre);
                    movie.setDuration(duration);
                    movie.setLanguage(language);
                    movie.setReleaseDate(releaseDate);
                    movie.setStatus(status);

                    dao.updateMovie(movie);

                    System.out.println("Movie updated successfully!");

                } else {

                    System.out.println("Movie not found!");
                }
            }

            // ================= DELETE MOVIE =================
            else if (choice == 5) {

                System.out.println();
                System.out.println("========== DELETE MOVIE ==========");

                System.out.print("Enter movie ID: ");
                int id = sc.nextInt();

                Movie movie = dao.getMovie(id);

                if (movie != null) {

                    System.out.println();
                    System.out.println("Movie to delete:");
                    System.out.println(movie);

                    sc.nextLine();

                    System.out.print("Are you sure? (yes/no): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {

                        dao.deleteMovie(id);

                    } else {

                        System.out.println("Delete cancelled!");
                    }

                } else {

                    System.out.println("Movie not found!");
                }
            }

            // ================= EXIT =================
            else if (choice == 6) {

                System.out.println();
                System.out.println("Thank you!");
                System.out.println("Program closed.");
            }

            // ================= INVALID CHOICE =================
            else {

                System.out.println();
                System.out.println("Invalid choice!");
                System.out.println("Please enter 1 to 6.");
            }

        } while (choice != 6);

        sc.close();

        HibernateUtil
                .getSessionFactory()
                .close();
    }
}