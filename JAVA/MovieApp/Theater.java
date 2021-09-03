import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Theater implements show{
    int theaterId;
    String theaterName;
    List<Movie> movies;
    static List<Theater> allTheaters = new ArrayList<>();
    Theater(){
        movies = new ArrayList<>();
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
     * @param id the theaterId to set
     */
    public void settheaterId(int id) {
        this.theaterId = id;
    }
    
    /**
     * @param name the theaterName to set
     */
    public void settheaterName(String name) {
        this.theaterName = name;
    }

    /**
     * function to add a theater
     */
    public static void addTheater() throws IOException{
        Theater obj = new Theater();
        allTheaters.add(obj);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Theater id : ");
        int id = Integer.parseInt(br.readLine());
        System.out.print("Enter Theater name : ");
        String name = br.readLine();
        System.out.print("Enter number of movies : ");
        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            System.out.print("Enter movie name : ");
            String movieName = br.readLine();
            Boolean flag = false;
            for(Movie mov : Movie.allMovies){
                if(mov.getName().equals(movieName)){
                    flag = true;
                    obj.movies.add(mov);
                }
            }
            if(!flag)
                System.out.println("Invalid movie name");
        }
        obj.settheaterId(id);
        obj.settheaterName(name);
    }

    /**
     * Display the data
     */
    @Override
    public void printData(){
        System.out.println("Theater ID : "+this.getTheaterId());
        System.out.println("Theater Name : "+this.getTheaterName());
        System.out.println("Movies of this theater are");
        int ind=1;
        for(Movie mov : this.movies){
            System.out.println(ind+++". "+mov.getName());
        }
        System.out.println();
    }

    /**
     * function to display all theaters
     */
    public static void displayTheater(){
        System.out.println("All Theaters are listed below");
        System.out.println();
        for(Theater th : allTheaters){
            th.printData();
            System.out.println();
        }
    }
}
