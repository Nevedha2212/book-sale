package com.book.sale;


import com.book.sale.factory.BookFactory;
import com.book.sale.model.Book;
import com.book.sale.model.ExternalArgs;
import com.book.sale.model.Sale;
import com.book.sale.utils.Utility;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        ExternalArgs externalArgs = Utility.parseExternalArguments(args);

        List<Book> bookList;
        List<Sale> saleList;

        // Initial check for path. This handles only NullPointerException and doesn't handle path not found exception
        if (externalArgs.getBookPath() == null || externalArgs.getSalesPath() == null) {
            System.out.println("Path not defined for either book or sale. Please define the path.");
            return;
        }

        // Try to parse CSV files. If unable to parse. Stop execution and print stack trace
        try {
            bookList = Utility.parseCsvToBookList(externalArgs.getBookPath());
            saleList = Utility.parseCsvToSaleList(externalArgs.getSalesPath());
        } catch (Exception e) {
            System.out.println("Error parsing CSV file");
            e.printStackTrace();
            return;
        }


        if (saleList != null && saleList.size() > 0 && externalArgs.getTopSellingBooks() > 0) {
            String output = BookFactory.computeTopSellingBooks(saleList, externalArgs.getTopSellingBooks());
            System.out.println(output);
        }

        if (saleList != null && saleList.size() > 0 && externalArgs.getTopCustomers() > 0) {
            String output = BookFactory.computeTopCustomers(saleList, externalArgs.getTopCustomers());
            System.out.println(output);
        }

        if (saleList != null && bookList != null && saleList.size() > 0 && bookList.size() > 0 && externalArgs.getSaleOnDate() != null) {
            String output = BookFactory.salesOnDate(bookList, saleList, externalArgs.getSaleOnDate());
            System.out.println(output);
        }


    }

}

