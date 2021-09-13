/**
  * movies whose budget is less than equal to 30cr
  */
public class SmallBudgetMovie extends Movie implements Predictable {

    /**
     * Constructor
     *
     * @param name name of the movie
     * @param year year of the movie
     * @param language language of the movie
     * @param genre genre of the movie
     * @param releaseDate release Date of the movie
     * @param type type of the movie
     * @param budget budget of the movie
     * @param collection collection of the movie
     */
    public SmallBudgetMovie(String name, int year, String language, String genre, String releaseDate, String type, int budget, int collection) {
        super(name, year, language, genre, releaseDate, type, budget, collection);
        this.setVerdict(this.predictBoxOfficeVerdict(collection, budget));
    }
    /**
     * overriding the function of the implemented interface
     * @param collection the collection value of the movie
     * @param budget the budget of the movie
     * @return verdict the verdict of the movie
     */
    @Override
    public String predictBoxOfficeVerdict(int collection, int budget) {
        int profit = (int)((((double)collection-(double)budget)/(double)collection)*100);
        if(profit<=10)
            this.setVerdict("Flop");
        else if(profit<=30)
            this.setVerdict("Hit");
        else if(profit<=60)
            this.setVerdict("Super Hit");
        else
            this.setVerdict("BlockBuster");
        return this.getVerdict();
    }

}
