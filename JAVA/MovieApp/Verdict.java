import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Verdict {
    /**
     * function to calculate and display the verdict of a movie
     */
    public static void calcverdictOfMovie() throws IOException{
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of movie: ");
        name = br.readLine();
        String verdict="";
        for(Movie mov : AllMovies.allMovies){
            if(mov.getName().equals(name)){
                verdict = mov.getVerdict();
            }
        }
        System.out.println(verdict);
    }
}
