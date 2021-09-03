import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

interface show{
    /**
      * prints data
      */
    void printData();
}

interface predictable{
    /**
      * @param collection collection of the movie
      * @param budget budget of the movie
      * @return String return box office verdict of the movie
      */
    String predictBoxOfficeVerdict(int collection,int budget);
}

/**
  * setting up the name and functionalities of movieType
  */
enum MovieType{
    TOLLYWOOD("TOLLYWOOD"),BOLLYWOOD("BOLLYWOOD"),HOLLYWOOD("HOLLYWOOD");
    String name;
    MovieType(String type){
        name = type;
    }
    @Override
    public String toString(){
        return name;
    }
}

/**
  * setting up the name and functionalities of dishType
  */
enum dishTypeList{
    DOSA("Dosa"), DAL("Dal Makhni"), PEPPER("Pepper Steak");
    String dishType;
    dishTypeList(String dishType){
        this.dishType = dishType;
    }
    @Override
    public String toString(){
        return dishType;
    }
}

/**
  * Movie class that contains data like name,year,genre
  * and functionalities to store and retrieve information of the movies
  */
class Movie implements show{
    private int year,budget,collection;
    private String name,language,genre,releaseDate,dish,verdict;
    private MovieType type;
    private Boolean blockBuster;
    private static Map<MovieType, String> dishType = new HashMap<>();
    static List<Movie> allMovies = new ArrayList<>();
    
    /**
     * connecting dishType with MovieType in static block
     */
    static{
        for(MovieType mov : MovieType.values()){
            dishType.put(mov,dishTypeList.values()[mov.ordinal()].toString());
        }
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
     * @return String return the dish
     */
    public String getDish() {
        return this.dish;
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
     * @return String return the type
     */
    public String getType() {
        String temp = "";
        for(MovieType mov : MovieType.values()){
            if(mov.equals(this.type)){
                temp = MovieType.values()[mov.ordinal()].toString();
            }
            dishType.put(mov,dishTypeList.values()[mov.ordinal()].toString());
        }
        return temp;
    }

    /**
     * @return int return the budget
     */
    public int getBudget() {
        return this.budget;
    }

    /**
     * @return int return the collection
     */
    public int getCollection() {
        return this.collection;
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = MovieType.valueOf(type.toUpperCase());
    }

    /**
     * @param budget the budger to set
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(int collection) {
        this.collection = collection;
    }

    /**
     * @param blockBuster the blockBuster to set
     */
    public void setBlockBuster() {
        Random random = new Random();
        this.blockBuster = random.nextBoolean();
    }
    
    /**
     * @param dishType the dishType to set
     */
    public void setDishType(String type) {
        this.dish = dishType.get(this.type);
    }

    /**
     * function to display all movies
     */
    public static void displayMovie(){
        System.out.println("All Movies are listed below");
        System.out.println();
        for(Movie mov : allMovies){
            mov.printData();
            System.out.println();
        }
    }

    /**
      * function to display movies based on type
      */
    public static void displayMovieByType() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Movie Type : ");
        String type = br.readLine();
        for(Movie mov : allMovies){
            if(mov.getType().equals(type)){
                mov.printData();
                System.out.println();
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
                mov.printData();
                System.out.println();
            }
        }
    }

    /**
     * function to add a movie
     */
    public static void addMovie() throws IOException{

        System.out.println("Add Movie");

        String name,language,releaseDate,type,genre;
        int year,budget,collection;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Movie Name : ");
        name = br.readLine();
        System.out.print("Enter Movie Year : ");
        year = Integer.parseInt(br.readLine());
        System.out.print("Enter Movie Language : ");
        language = br.readLine();
        System.out.print("Enter Movie Genre : ");
        genre = br.readLine();
        System.out.print("Enter release Date : ");
        releaseDate = br.readLine();
        System.out.print("Enter Type of movie : ");
        type = br.readLine();
        System.out.print("Enter Budget of movie (in Cr) : ");
        budget = Integer.parseInt(br.readLine());
        System.out.print("Enter Collection of movie (in Cr) : ");
        collection = Integer.parseInt(br.readLine());
        if(budget<=30){
            SmallBudgetMovie obj1 = new SmallBudgetMovie();
            obj1.setName(name);
            obj1.setYear(year);
            obj1.setLanguage(language);
            obj1.setGenre(genre);
            obj1.setReleaseDate(releaseDate);
            obj1.setType(type);
            obj1.setBudget(budget);
            obj1.setCollection(collection);
            obj1.setVerdict(obj1.predictBoxOfficeVerdict(collection,budget));
            obj1.setBlockBuster();
            obj1.setDishType(type);
            allMovies.add(obj1);
        }
        else{
            LargeBudgetMovie obj2 = new LargeBudgetMovie();
            obj2.setName(name);
            obj2.setYear(year);
            obj2.setLanguage(language);
            obj2.setGenre(genre);
            obj2.setReleaseDate(releaseDate);
            obj2.setType(type);
            obj2.setBudget(budget);
            obj2.setCollection(collection);
            obj2.setVerdict(obj2.predictBoxOfficeVerdict(collection,budget));
            obj2.setBlockBuster();
            obj2.setDishType(type);
            allMovies.add(obj2);
        }   
    }

    /**
     * function to calculate and display the verdict of a movie
     */
    public static void calcverdictOfMovie() throws IOException{
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
     * Display the data
     */
    @Override
    public void printData(){
        System.out.println("Name : "+this.getName());
        System.out.println("Year : "+this.getYear());
        System.out.println("Language : "+this.getLanguage());
        System.out.println("Genre : "+this.getGenre());
        System.out.println("Release Date : "+this.getReleaseDate());
        System.out.println("Type : "+this.getType());
        System.out.println("Dish : "+this.getDish());
        System.out.println("Blockbuster : "+this.getBlockBuster());
        System.out.println();
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