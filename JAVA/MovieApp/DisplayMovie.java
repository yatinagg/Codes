import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayMovie {
    /**
     * function to display all movies
     */
    public static void displayMovie(){
        System.out.println("All Movies are listed below");
        System.out.println();
        for(Movie mov : AllMovies.allMovies){
            Movie.printData(mov);
            System.out.println();
        }
    }

    public static void displayMovieByType() throws IOException{
        /**
         * function to display movies based on type
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Movie Type : ");
        String type = br.readLine();
        for(Movie mov : AllMovies.allMovies){
            if(mov.getType().equals(type)){
                Movie.printData(mov);
                System.out.println();
            }
        }
    }

    public static void displayMovieByBudget() throws IOException{
        /**
         * function to display movies based on budget
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter budget (in cr): ");
        int budget = Integer.parseInt(br.readLine());
        for(Movie mov : AllMovies.allMovies){
            if(mov.getBudget()==budget){
                Movie.printData(mov);
                System.out.println();
            }
        }
    }
}
