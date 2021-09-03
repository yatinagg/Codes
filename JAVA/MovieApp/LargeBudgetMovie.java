/**
  * movies whose budget is greater than 30cr
  */
public class LargeBudgetMovie extends Movie implements predictable{

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
