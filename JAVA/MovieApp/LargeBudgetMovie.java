/**
  * movies whose budget is greater than 30cr
  */
public class LargeBudgetMovie extends Movie implements Predictable{

    /**
     * Constructor
     *
     * @param name
     * @param year
     * @param language
     * @param genre
     * @param releaseDate
     * @param type
     * @param budget
     * @param collection
     */
    public LargeBudgetMovie(String name, int year, String language, String genre, String releaseDate, String type, int budget, int collection) {
        super(name, year, language, genre, releaseDate, type, budget, collection);
        this.setVerdict(this.predictBoxOfficeVerdict(collection,budget));
    }

    /**
     * @param collection the collectionvalue of the movie
     * @param budget the budget of the movie
     * @return verdict the verdict of the movie
     */
    @Override
    public String predictBoxOfficeVerdict(int collection,int budget){
        int profit = (int)((((double)collection-(double)budget)/(double)collection)*100);
        if(profit<=10)
            this.setVerdict("Flop");
        else if(profit<=60)
            this.setVerdict("Hit");
        else if(profit<=100)
            this.setVerdict("Super Hit");
        else
            this.setVerdict("BlockBuster");
        return this.getVerdict();
    }


}
