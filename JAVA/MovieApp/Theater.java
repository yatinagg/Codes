import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Theater {
    private final int theaterId;
    private String theaterName;
    private List<Movie> movies;
    private static List<Theater> allTheaters = new ArrayList<>();
    Theater(int id, String theaterName) {
        movies = new ArrayList<>();
        theaterId = id;
        this.theaterName = theaterName;
    }

    /**
     * @return int return the theaterId
     */
    public int getTheaterId() {
        return this.theaterId;
    }

    /**
     * @return String return the theaterName
     */
    public String getTheaterName() {
        return this.theaterName;
    }

    /**
     * function to add a theater
     */
    public static void addTheater(int id, String TheaterName, List<Movie> movies) throws IOException {
        Theater obj = new Theater(id, TheaterName);
        allTheaters.add(obj);
        for(Movie mov : movies)
            obj.movies.add(mov);
    }

    /**
     * Display the data of the object
     */
    @Override
    public String toString() {
        String data = "";
        data += "ID : " + this.getTheaterId() + "  ";
        data += "Name : " + this.getTheaterName() + "  ";
        data += "Movies of this theater are : ";
        for(Movie mov : this.movies)
            data += mov.getName() + ",";
        return data;
    }

    /**
     * function to display all theaters
     */
    public static void displayTheater() {
        System.out.println("All Theaters are listed below");
        System.out.println();
        for(Theater th : allTheaters)
            System.out.println(th);
    }
}
