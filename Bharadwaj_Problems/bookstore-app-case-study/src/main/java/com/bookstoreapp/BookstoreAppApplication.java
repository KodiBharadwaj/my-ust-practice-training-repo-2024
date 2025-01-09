package com.bookstoreapp;


import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.service.BookstoreService;
import com.bookstoreapp.service.BookstoreServiceImpl;

public class BookstoreAppApplication {

	public static void main(String[] args) {
		BookstoreService bookstoreService = new BookstoreServiceImpl();

//		Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);
//		Book book1 = new Book(2, "The Great Gatsby", "F. Scott Fitzgerald", 1925,156266262612L,300.0);
//		Book book2= new Book(3, "The Kite Runner", "Khaled Hosseini", 2003,156266262613L,350.0);
//		Book book3 = new Book(4, "The Little Prince", "Antoine de Saint-Exupery", 1943,156266262614L,400.0);


//		System.out.println(bookstoreService.saveBook(book));
//		System.out.println(bookstoreService.saveBook(book1));
//		System.out.println(bookstoreService.saveBook(book2));
//		System.out.println(bookstoreService.saveBook(book3));


//		System.out.println(bookstoreService.getBookById(1));
//		System.out.println(bookstoreService.getBookById(2));
//		System.out.println(bookstoreService.getBookById(3));
//		System.out.println(bookstoreService.getBookById(4));


//		System.out.println(bookstoreService.getBookById(5));


//		System.out.println(bookstoreService.getAllBooks());
//		bookstoreService.deleteBook(1);


	}

}
