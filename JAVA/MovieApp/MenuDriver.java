import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuDriver {
    /**
      * menuDriver which consists of menu driven code
      */
    static void menuDriver() throws IOException, InterruptedException{
        int choice=0;
        while(choice!=-1){
            System.out.println("Welcome to Movie App");
            System.out.println("1. Add new Movie");
            System.out.println("2. Display All Movies");
            System.out.println("3. Display movies by type");
            System.out.println("4. Display movies by Budget");
            System.out.println("5. Check movie is blockbuster");
            System.out.println("6. Calculate Verdict of movie");
            System.out.println("7. Exit");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    AddMovie.addMovie();
                    break;
                case 2:
                    DisplayMovie.displayMovie();
                    break;
                case 3:
                    DisplayMovie.displayMovieByType();
                    break;
                case 4:
                    DisplayMovie.displayMovieByBudget();
                    break;
                case 5:
                    System.out.println("Enter the movie name : ");
                    String mov = br.readLine();
                    System.out.println(Movie.isBlockBuster(mov));
                    break;
                case 6:
                    Verdict.calcverdictOfMovie();
                    break;
                case 7:
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
