package com.book.sale.factory;

import com.book.sale.model.Sale;

import java.util.*;

public class BookFactory {

    public static String computeTopSellingBooks(List<Sale> sales, int n) {
        HashMap<String, Integer> topSellingBooks = new HashMap<>();

        for (Sale sale : sales) {
            for (Sale.BookSale bookSale : sale.getBookSales()) {
                topSellingBooks.merge(bookSale.getId(), bookSale.getQuantity(), (a, b) -> a + b);
            }
        }

        Set<String> set = topSellingBooks.keySet();
        List<String> keys = new ArrayList<>(set);
        keys.sort((o1, o2) -> Integer.compare(topSellingBooks.get(o2), topSellingBooks.get(o1)));

        // Safety check, if number of books asked for is more than the actual number of books, set the number of book to max
        if (n >= keys.size()) {
            n = keys.size();
        }

        List<String> output = new ArrayList<>(keys.subList(0, n));

        return printOutput("top_selling_books", output);
    }

    public static String computeTopCustomers(List<Sale> sales, int n) {
        HashMap<String, Integer> topCustomers = new HashMap<>();

        for (Sale sale: sales) {
            topCustomers.merge(sale.getEmail(), 1, (a, b) -> a + b);
        }

        Set<String> set = topCustomers.keySet();
        List<String> keys = new ArrayList<>(set);
        keys.sort((o1, o2) -> Integer.compare(topCustomers.get(o2), topCustomers.get(o1)));

        // Safety check, if number of customer asked for is more than the actual number of customer, set the number of customer to max
        if (n >= keys.size()) {
            n = keys.size();
        }

        List<String> output = new ArrayList<>(keys.subList(0, n));

        return printOutput("top_customers", output);
    }

    public static String salesOnDate(List<Sale> sales, String date) {
        HashMap<String, Integer> salesOnDate = new HashMap<>();

        for (Sale sale: sales) {
            salesOnDate.merge(sale.getDate(), 1, (a, b) -> a + b);
        }

        return "sales_on_date" + "\t" + date + "\t" + salesOnDate.get(date) + "\n";
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