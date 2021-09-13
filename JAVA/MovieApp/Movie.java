import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
  * Movie class that contains data like name,year,genre
  * and functionalities to store and retrieve information of the movies
  */
public abstract class Movie {
    private int year;
    private int budget;
    private int collection;
    private String id;
    private String name;
    private String language;
    private String genre;
    private String releaseDate;
    private String verdict;
    private Boolean blockBuster;
    private MovieType type;
    private static int currentId = 001;
    protected static List<Movie> allMovies = new ArrayList<>();

    // Constructor
    public Movie(String name, int year, String language, String genre, String releaseDate, String type, int budget, int collection) {
        this.id = "M" + String.format("%03d", currentId++);
        this.name = name;
        this.year = year;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.type = MovieType.valueOf(type);
        this.budget = budget;
        this.collection = collection;
        Random random = new Random();
        this.blockBuster = random.nextBoolean();
        allMovies.add(this);
    }

    /**
     * @return String return details of movie object
     */
    @Override
    public String toString() {
        return id + " " + name + "  " + year + "  " + language + "  " + genre + "  " + releaseDate + "  " + type.getMovieType() + "  " + type.getDish() + "  " + blockBuster;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * @return String return the releaseDate
     */
    public String getReleaseDate() {
        return this.releaseDate;
    }

    /**
     * @return String return the genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * @return MovieType return the type
     */
    public MovieType getType() {
        return this.type;
    }

    /**
     * @return String return the language
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return int return the budget
     */
    public int getBudget() {
        return this.budget;
    }

    /**
     * @return String return the verdict
     */
    public String getVerdict() {
        return this.verdict;
    }

    /**
     * @return Boolean return whether blockBuster or not
     */
    public Boolean getBlockBuster() {
        return this.blockBuster;
    }

    /**
     * @param verdict the verdict to set
     */
    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    /**
     * function to display all movies
     */
    public static void displayMovie() {
        System.out.println("All Movies are listed below");
        for(Movie mov : allMovies)
            System.out.println(mov);
    }

    /**
      * function to display movies based on type
      */
    public static void displayMovieByType(String type) throws IOException {
        for(Movie mov : allMovies) {
            if(mov.getType().getMovieType().equals(type))
                System.out.println(mov);
        }
    }

    /**
      * function to display movies based on budget
      */
    public static void displayMovieByBudget() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter budget (in cr): ");
        int budget = Integer.parseInt(br.readLine());
        for(Movie mov : allMovies) {
            if(mov.getBudget() == budget)
                System.out.println(mov);
        }
    }

    /**
     * function to add a movie
     */
    public static void addMovie(String name, int year, String language,String genre, String releaseDate, String type, int budget, int collection) throws IOException {
        if(budget <= 30)
            new SmallBudgetMovie(name, year, language, genre, releaseDate, type, budget, collection);
        else
            new LargeBudgetMovie(name, year, language, genre, releaseDate, type, budget, collection);
    }

    /**
     * function to calculate and display the verdict of a movie
     */
    public static void calcVerdictOfMovie() throws IOException {
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of movie: ");
        name = br.readLine();
        String verdict = "";
        for(Movie mov : allMovies) {
            if(mov.getName().equals(name))
                verdict = mov.getVerdict();
        }
        System.out.println(verdict);
    }

    /**
     * @param name the name of the movie
     * @return Movie return the object with the movie name
     */
    public static Movie getMovieObjectByName(String name) {
        for(Movie mov : allMovies) {
            if(mov.name.equals(name))
                return mov;
        }
        return null;
    }

    /**
     * @return Boolean return true if blockbuster else false
     */
    public Boolean isBlockBuster() {
        return this.blockBuster;
    }

}