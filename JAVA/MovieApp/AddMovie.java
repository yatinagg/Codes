import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddMovie{
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
            obj1.setVerdict(obj1.calcBoxOfficeVerdict(collection,budget));
            obj1.setBlockBuster();
            obj1.setDishType(type);
            AllMovies.allMovies.add(obj1);
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
            obj2.setVerdict(obj2.calcBoxOfficeVerdict(collection,budget));
            obj2.setBlockBuster();
            obj2.setDishType(type);
            AllMovies.allMovies.add(obj2);
        }
        
    }
}
