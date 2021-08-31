import java.util.*;

class Movie{
    private int year;
    private String name,language,genre,releasedate,type,dish;
    private Boolean blockbuster;
    public static List<Movie> movies = new ArrayList<>();

    // Constructor
    public Movie(String name,int year,String language,String genre,String releasedate,String type){
        this.name = name;
        this.year = year;
        this.language = language;
        this.genre = genre;
        this.releasedate = releasedate;
        this.type = type;
        Random random = new Random();
        this.blockbuster = random.nextBoolean();
        if(type=="TollyWood")
            this.dish = "Dosa";
        else if(type=="BollyWood")
            this.dish = "Dal Makhni";
        else if(type=="HollyWood")
            this.dish = "Pepper Steak";
        movies.add(this);
    }

    // function for display data
    private static void printData(Movie it){
        System.out.println("Name : "+it.name);
        System.out.println("Year : "+it.year);
        System.out.println("Language : "+it.language);
        System.out.println("Genre : "+it.genre);
        System.out.println("Release Date : "+it.releasedate);
        System.out.println("Type : "+it.type);
        System.out.println("Dish : "+it.dish);
        System.out.println("Blockbuster : "+it.blockbuster);
        System.out.println();
    }

    public static void getMovies(){
        for(Movie it : movies)
            printData(it);
    }

    public static void getMoviesByType(String type){
        for(Movie it : movies){
            if(it.type==type)
                printData(it);
        }
    }
}

class MovieApp{
    public static void main(String[] args){
        Movie movie1 = new Movie("Partner",2000,"Hindi","Comedy","20/05","BollyWood");
        Movie movie2 = new Movie("Bhuj",2021,"Hindi","Action","15/08","BollyWood");
        Movie movie3 = new Movie("Jersey",2019,"Hindi","Sports","01/11","TollyWood");
        Movie movie4 = new Movie("Dhammal",2005,"Hindi","Comedy","12/01","BollyWood");
        Movie.getMovies();
        Movie.getMoviesByType("TollyWood");
    }
}