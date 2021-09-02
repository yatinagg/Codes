import java.util.*;

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
    public static String getEnumByString(String type){
        for(MovieType e : MovieType.values()){
            if(e.name.equals(type)){
                System.out.println(e.name());
                return e.name();
            }
        }
        return null;
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
class Movie{
    private int year,budget,collection;
    private String name,language,genre,releaseDate,dish,verdict;
    private MovieType type;
    private Boolean blockBuster;
    private static Map<MovieType, String> dishType = new HashMap<>();
    
    /**
     * connecting dishType with MovieType in static block
     */
    static{
        for(MovieType mov : MovieType.values()){
            dishType.put(mov,dishTypeList.values()[mov.ordinal()].toString());
        }
    }

    /**
     * Display the data
     * @param it the Movie object
     */
    public static void printData(Movie it){
        System.out.println("Name : "+it.name);
        System.out.println("Year : "+it.year);
        System.out.println("Language : "+it.language);
        System.out.println("Genre : "+it.genre);
        System.out.println("Release Date : "+it.releaseDate);
        System.out.println("Type : "+it.type);
        System.out.println("Dish : "+it.dish);
        System.out.println("Blockbuster : "+it.blockBuster);
        System.out.println();
    }

    /**
     * @param name the name to check
     * @return Boolean return true if blockbuster else false
     */
    public static Boolean isBlockBuster(String name){
        for(Movie mov : AllMovies.allMovies){
            if(mov.name.equals(name)){
                return mov.blockBuster;
            }
        }
        return false;
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
    
}