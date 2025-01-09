package com.stackroute.generic;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Predicate;

public class BookTitleSearcher {

    public Optional<List<String>> getBookList(List<String> booksList, String str){
        if(booksList == null || str == "" || str == null){
            return Optional.empty();
        }
        List<String> list = new ArrayList<>();

        for(String i: booksList){
            if(i.contains(str)){
                list.add(i);
            }
        }
        if(list.size() == 0) return Optional.empty();
        return Optional.of(list);
    }

    public Optional<List<String>> searchBookNames(List<String> bookList, Predicate<String> predicate){
        if(bookList == null || bookList.isEmpty()){
            return Optional.empty();
        }
        List<String> list = new ArrayList<>();

        for(String str: bookList){
            if(predicate.test(str)){
                list.add(str);
            }
        }
        return Optional.of(list);
    }
}
