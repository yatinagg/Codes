interface Predictable {
    /**
     * @param collection collection of the movie
     * @param budget     budget of the movie
     * @return String return box office verdict of the movie
     */
    String predictBoxOfficeVerdict(int collection, int budget);
}