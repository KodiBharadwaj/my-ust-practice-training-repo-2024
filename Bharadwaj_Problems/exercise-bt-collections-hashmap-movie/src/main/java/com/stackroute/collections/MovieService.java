package com.stackroute.collections;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
This class contains a property called movieMap of type Map
This class contains methods for adding key-value pairs of Movie and its rating to HashMap and
various methods for accessing the keys and values based on some conditions
 */
public class MovieService {

    public int releaseDate;
    Map<Movie, Integer> m = new LinkedHashMap<>();

    /**
     * Constructor to create movieMap as an empty  LinkedHashMap object
     */
    public MovieService() {
        this.m = new LinkedHashMap<>();
    }

    /*
    Returns the movieMap object
     */
    public Map<Movie, Integer> getMovieMap() {
        return m;
    }

    /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {
        m.put(movie, rating);
        return m.entrySet();
    }

    /*
    Return Set of movie names having rating greater than or equal to given rating
     */
    public List<String> getHigherRatedMovieNames(int rating) {
        List<String> stringList = new ArrayList<>();
//        for(var i : m.keySet()){
//            if(m.get(i) >= rating){
//                stringList.add(i.getMovieName());
//            }
//        }
        m.entrySet().stream().filter(i->i.getValue() >= rating).forEach(i->stringList.add(i.getKey().getMovieName()));

        return stringList;
    }

    /*
    Return Set of movie names belonging to specific genre
     */
    public List<String> getMovieNamesOfSpecificGenre(String genre) {
        List<String> genreList = new ArrayList<>();
//        for(var i: m.keySet()){
//            if(i.getGenre().equals(genre)){
//                genreList.add(i.getMovieName());
//            }
//        }
        m.entrySet().stream().filter(i->i.getKey().getGenre().equals(genre)).forEach(i->genreList.add(i.getKey().getMovieName()));

        return genreList;
    }


   /*
   Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */

    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(LocalDate releaseDate) {
        List<String> list = new ArrayList<>();
//        for(Movie i: m.keySet()){
//            if(i.getReleaseDate().compareTo(releaseDate)>0 && m.get(i) <= 3){
//                list.add(i.getMovieName());
//            }
//        }
        m.entrySet().stream().filter(i->i.getKey().getReleaseDate().compareTo(releaseDate) > 0 && i.getValue() <= 3).forEach(i->list.add(i.getKey().getMovieName()));

        return list;
    }

    /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
    public List<Movie> getSortedMovieListByReleaseDate() {
        return m.keySet().stream().sorted((a,b)-> a.getReleaseDate().compareTo(b.getReleaseDate())).toList();
    }

    /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
    public Map<Movie, Integer> getSortedMovieListByRating() {
        Map<Movie, Integer> outputMap = new LinkedHashMap<>();
        m.entrySet().stream().sorted((a,b)->a.getValue()-b.getValue()).forEach(i->outputMap.put(i.getKey(), i.getValue()));
        return outputMap;
    }

}
