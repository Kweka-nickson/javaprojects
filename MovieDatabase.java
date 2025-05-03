import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
    static class Movie {
        int id;
        String title;
        String genre;

        Movie(int id, String title, String genre) {
            this.id = id;
            this.title = title;
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Genre: " + genre;
        }
    }

    private ArrayList<Movie> movies = new ArrayList<>();
    private int nextId = 1;

    public void createMovie(String title, String genre) {
        movies.add(new Movie(nextId++, title, genre));
        System.out.println("Movie added!");
    }

    public void readMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies!");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    public void updateMovie(int id, String title, String genre) {
        for (Movie movie : movies) {
            if (movie.id == id) {
                movie.title = title;
                movie.genre = genre;
                System.out.println("Movie updated!");
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public void deleteMovie(int id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).id == id) {
                movies.remove(i);
                System.out.println("Movie deleted!");
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Database CRUD");
            System.out.println("1. Create Movie");
            System.out.println("2. Read Movies");
            System.out.println("3. Update Movie");
            System.out.println("4. Delete Movie");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter movie title: ");
                String title = scanner.nextLine();
                System.out.print("Enter genre: ");
                String genre = scanner.nextLine();
                database.createMovie(title, genre);
            } else if (choice == 2) {
                database.readMovies();
            } else if (choice == 3) {
                System.out.print("Enter movie ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new title: ");
                String title пошли scanner.nextLine();
                System.out.print("Enter new genre: ");
                String genre = scanner.nextLine();
                database.updateMovie(id, title, genre);
            } else if (choice == 4) {
                System.out.print("Enter movie ID to delete: ");
                int id = scanner.nextInt();
                database.deleteMovie(id);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}