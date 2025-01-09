package com.stackroute.streams;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class has various methods to do stream operations on person collection
 */
public class PersonStreamOperations {

    /**
     * sorts the person list alphabetically in uppercase
     * Returns Empty Optional if the given list is null or empty
     *
     * @param personList
     * @return
     */
    public Optional<List<String>> getPersonListSortedByNameInUpperCase(List<String> personList) {

        if (personList == null || personList.isEmpty()) {
            return Optional.empty();
        }

        List<String> list = personList.stream()
                .filter(s->s.trim().length() > 0)
                .sorted((a, b)->a.compareTo(b))
                .map(s->s.toUpperCase())
                .toList();

        return Optional.of(list);
    }

    /**
     * Sorts the distinct person names in descending order
     * Returns empty set if the given list is empty or null
     *
     * @param personList
     * @return
     */

    public Set<String> getDistinctPersonNamesSortedInDescendingOrder(List<String> personList) {

        if(personList == null || personList.isEmpty()){
            return Collections.emptySet();
        }

        List<String> list = new ArrayList<>(personList);
        list = personList.stream()
                .filter(s->s.trim().length() > 0)
                .sorted((a,b)->b.compareTo(a)).toList();
        Set<String> set = new LinkedHashSet<>(list);
        return set;
    }

    /**
     * Returns "Person found" if the person searched is available in the list or else returns "Person not found"
     * Returns "Give proper input not null" if the given list or name to search is null
     *
     * @param personList
     * @return
     */
    public String searchPerson(List<String> personList, String nameToSearch) {
        if (personList == null || nameToSearch == null) {
            return "Give proper input not null";
        }

        boolean bool = personList.stream().anyMatch(s->s.equalsIgnoreCase(nameToSearch));
        if(bool == true) return "Person found";
        else return "Person not found";

    }

    /**
     * Filters the list whose name length is greater than five and sorts by name length
     * Returns empty list if the given list is empty or null
     *
     * @param personList
     * @return
     */

    public List<String> getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String> personList) {
        if(personList == null || personList.isEmpty()){
            return Collections.emptyList();
        }

        List<String> list = personList.stream()
                .filter(s->s.length() > 5)
                .sorted((a,b)->a.length()-b.length()).toList();

        return list;
    }

    /**
     * Returns the person name having maximum age from the given Map<String,Integer> having name as key and age as value
     * Returns "Give proper input not null" if the given map is empty or null
     *
     * @param personMap
     * @return
     */

    public String getPersonByMaxAge(Map<String, Integer> personMap) {

        if(personMap == null || personMap.isEmpty()){
            return "Give proper input not null";
        }
//        int maxAge = Integer.MIN_VALUE;
//        String str = "";
//        for(String i: personMap.keySet()){
//            int age = personMap.get(i);
//            if(age > maxAge){
//                maxAge = age;
//                str = i;
//            }
//        }
//
//
//        return str;

        return personMap.keySet().stream().reduce((a,b)->{
            if(personMap.get(b) > personMap.get(a)){
                a = b;
            }
            return a;
        }).get();
    }

}
