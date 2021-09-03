import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieApp{
    /**
     * main function which comprises of menu driven code
     */
    public static void main(String[] args) throws IOException, InterruptedException{
        int choice=0;
        while(choice!=-1){
            System.out.println("Welcome to Movie App");
            System.out.println("1. Add new Movie");
            System.out.println("2. Display All Movies");
            System.out.println("3. Display movies by type");
            System.out.println("4. Display movies by Budget");
            System.out.println("5. Check movie is blockbuster");
            System.out.println("6. Calculate Verdict of movie");
            System.out.println("7. Add new Theater");
            System.out.println("8. Display All Theaters");
            System.out.println("9. Exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    Movie.addMovie();
                    break;
                case 2:
                    Movie.displayMovie();
                    break;
                case 3:
                    Movie.displayMovieByType();
                    break;
                case 4:
                    Movie.displayMovieByBudget();
                    break;
                case 5:
                    System.out.println("Enter the movie name : ");
                    String mov = br.readLine();
                    System.out.println(Movie.isBlockBuster(mov));
                    break;
                case 6:
                    Movie.calcverdictOfMovie();
                    break;
                case 7:
                    Theater.addTheater();
                    break;
                case 8:
                    Theater.displayTheater();
                    break;
                case 9:
                    choice = -1;
                    System.out.println("Exiting");
                    Thread.sleep(1000);
                    System.out.println("Exited");
                    break;
                default:
                    choice = -1;
                    System.out.println("Invalid Choice");
            }
        }
    }
}