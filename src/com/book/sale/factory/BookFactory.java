package com.book.sale.factory;

import com.book.sale.model.Book;
import com.book.sale.model.Sale;

import java.util.*;

public class BookFactory {

    // Converting list of sale to Hashmap, create price map with book list and counting operation is performed(w.r.t price). After counting, sort is performed and top n selling books are picked

    public static String computeTopSellingBooks(List<Book> books,List<Sale> sales, int n) {
        HashMap<String, Float> topSellingBooks = new HashMap<>();
        HashMap<String, Float> booksMap = new HashMap<>();

        for(Book b: books) {
            booksMap.put(b.getId(),b.getPrice());
        }

        for (Sale sale : sales) {
            for (Sale.BookSale bookSale : sale.getBookSales()) {
                 Float priceValue = topSellingBooks.get(bookSale.getId());
                 if (priceValue == null)
                     topSellingBooks.put(bookSale.getId(), (bookSale.getQuantity() * booksMap.get(bookSale.getId())));
                 else
                     topSellingBooks.put(bookSale.getId(), priceValue + (bookSale.getQuantity() * booksMap.get(bookSale.getId())));
            }
        }

        Set<String> set = topSellingBooks.keySet();
        List<String> keys = new ArrayList<>(set);
        keys.sort((o1, o2) -> Float.compare(topSellingBooks.get(o2), topSellingBooks.get(o1)));

        // Safety check, if number of books asked for is more than the actual number of books, set the number of book to max
        if (n >= keys.size()) {
            n = keys.size();
        }

        List<String> output = new ArrayList<>(keys.subList(0, n));

        return printOutput("top_selling_books", output);
    }

    // Converting list of sale to Hashmap, create price map with books list and counting operation is performed(w.r.t price and quantity). After counting, sort is performed and top n customers are picked

    public static String computeTopCustomers(List<Book> books, List<Sale> sales, int n) {
        HashMap<String, Float> topCustomers = new HashMap<>();
        HashMap<String, Float> booksMap = new HashMap<>();

        for(Book b: books) {
            booksMap.put(b.getId(),b.getPrice());
        }

        for (Sale sale : sales) {
            for (Sale.BookSale bookSale : sale.getBookSales()) {
                Float priceValue = topCustomers.get(sale.getEmail());
                if (priceValue == null)
                    topCustomers.put(sale.getEmail(),(bookSale.getQuantity() * booksMap.get(bookSale.getId())));
                else
                    topCustomers.put(sale.getEmail(), priceValue + (bookSale.getQuantity() * booksMap.get(bookSale.getId())));
            }
        }

        Set<String> set = topCustomers.keySet();
        List<String> keys = new ArrayList<>(set);
        keys.sort((o1, o2) -> Float.compare(topCustomers.get(o2), topCustomers.get(o1)));

        // Safety check, if number of books asked for is more than the actual number of books, set the number of book to max
        if (n >= keys.size()) {
            n = keys.size();
        }

        List<String> output = new ArrayList<>(keys.subList(0, n));

        return printOutput("top_customers", output);
    }

    // Converting list of books to Hashmap and for given date, calculating total amount from sales list

    public static String salesOnDate(List<Book> books, List<Sale> sales, String date) {
        HashMap<String, Float> booksMap = new HashMap<>();
        float totalAmount = 0;
        for(Book b: books) {
            booksMap.put(b.getId(),b.getPrice());
        }
        for (Sale sale: sales) {
            if(sale.getDate().equalsIgnoreCase(date)) {
                for (Sale.BookSale bookSale : sale.getBookSales())
                    totalAmount = totalAmount + booksMap.get(bookSale.getId()) * bookSale.getQuantity();
            }
        }

        return "sales_on_date" + "\t" + date + "\t" + totalAmount + "\n";
    }

    // Printing the output as per the requirement
    private static String printOutput(String name, List<String> strings) {
        StringBuilder str = new StringBuilder(name);
        for (String s: strings) {
            str.append("\t").append(s);
        }
        str.append("\n");
        return str.toString();
    }

}