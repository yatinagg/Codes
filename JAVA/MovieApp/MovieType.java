/**
 * setting up the name and functionalities of movieType
 */
enum MovieType {
    TOLLYWOOD("TOLLYWOOD","DOSA"),BOLLYWOOD("BOLLYWOOD","DAL_MAKHNI"),HOLLYWOOD("HOLLYWOOD","PEPPER_STEAK");
    String type;
    String dish;
    MovieType(String type, String dish) {
        this.type = type;
        this.dish = dish;
    }
    public String getMovieType(){
        return type;
    }
    public String getDish(){
        return dish;
    }
}