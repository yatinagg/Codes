import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


interface Predictable {
    /**
     * @param collection collection of the movie
     * @param budget     budget of the movie
     * @return String return box office verdict of the movie
     */
    String predictBoxOfficeVerdict(int collection, int budget);
}
/**
  * setting up the name and functionalities of movieType
  */
enum MovieType{
    TOLLYWOOD("TOLLYWOOD","DOSA"),BOLLYWOOD("BOLLYWOOD","DAL_MAKHNI"),HOLLYWOOD("HOLLYWOOD","PEPPER_STEAK");
    String type;
    String dish;
    MovieType(String type,String dish){
        this.type = type;
        this.dish = dish;
    }
    public String getMovieType(){
        return type;
    }
    public String getDish(){
        return dish;
    }
}

/**
  * Movie class that contains data like name,year,genre
  * and functionalities to store and retrieve information of the movies
  */
class Movie{
    private int year;
    private int budget;
    private int collection;
    private String name;
    private String language;
    private String genre;
    private String releaseDate;
    private String verdict;
    private Boolean blockBuster;
    MovieType type;
    static List<Movie> allMovies = new ArrayList<>();

    // Constructor
    public Movie(String name, int year, String language, String genre, String releaseDate, String type, int budget, int collection){
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
    public String toString(){
        return name + "  " + year + "  " + language + "  " + genre + "  " + releaseDate + "  " + type.getMovieType() + "  " + type.getDish() + "  " + blockBuster;
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
    public static void displayMovie(){
        System.out.println("All Movies are listed below");
        for(Movie mov : allMovies){
            System.out.println(mov);
        }
    }

    /**
      * function to display movies based on type
      */
    public static void displayMovieByType(String type) throws IOException{
        for(Movie mov : allMovies){
            if(mov.getType().getMovieType().equals(type)){
                System.out.println(mov);
            }
        }
    }

    /**
      * function to display movies based on budget
      */
    public static void displayMovieByBudget() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter budget (in cr): ");
        int budget = Integer.parseInt(br.readLine());
        for(Movie mov : allMovies){
            if(mov.getBudget()==budget){
                System.out.println(mov);
            }
        }
    }

    /**
     * function to add a movie
     */
    public static void addMovie(String name, int year, String language,String genre, String releaseDate, String type, int budget, int collection) throws IOException{


        if(budget<=30){
            SmallBudgetMovie obj1 = new SmallBudgetMovie(name, year, language, genre, releaseDate, type, budget, collection);
            obj1.setVerdict(obj1.predictBoxOfficeVerdict(collection,budget));
        }
        else{
            LargeBudgetMovie obj2 = new LargeBudgetMovie(name, year, language, genre, releaseDate, type, budget, collection);
            obj2.setVerdict(obj2.predictBoxOfficeVerdict(collection,budget));
        }   
    }

    /**
     * function to calculate and display the verdict of a movie
     */
    public static void calcVerdictOfMovie() throws IOException{
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of movie: ");
        name = br.readLine();
        String verdict="";
        for(Movie mov : allMovies){
            if(mov.getName().equals(name)){
                verdict = mov.getVerdict();
            }
        }
        System.out.println(verdict);
    }

    /**
     * @param name the name to check
     * @return Boolean return true if blockbuster else false
     */
    public static Boolean isBlockBuster(String name){
        for(Movie mov : allMovies){
            if(mov.name.equals(name)){
                return mov.blockBuster;
            }
        }
        return false;
    }
}