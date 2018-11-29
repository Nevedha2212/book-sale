package com.book.sale.utils;

import com.book.sale.model.Book;
import com.book.sale.model.ExternalArgs;
import com.book.sale.model.Sale;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static ExternalArgs parseExternalArguments(String[] args) {
        // Just for debug purpose
        String[] argsTemp = { "--books=/Users/nevedha/Projects/BookSale/asset/books.list",
                "--sales=/Users/nevedha/Projects/BookSale/asset/sales.list",
                "--top_selling_books=3", "--top_customers=2", "--sales_on_date=2018-09-02" };

        String BOOKS_ARG = "--books=";
        String SALES_ARG = "--sales=";
        String TOP_SELLING_BOOKS_ARG = "--top_selling_books=";
        String TOP_CUSTOMERS_ARG = "--top_customers=";
        String SALES_ON_DATE_ARG = "--sales_on_date=";

        
        ExternalArgs externalArgs = new ExternalArgs();

        // Loops through all the args and created the ExternalArgs POJO
        for (String arg: args) {
            if (arg.startsWith(BOOKS_ARG)) {
                externalArgs.setBookPath(arg.replace(BOOKS_ARG, ""));
            } else if (arg.startsWith(SALES_ARG)) {
                externalArgs.setSalesPath(arg.replace(SALES_ARG, ""));
            } else if (arg.startsWith(TOP_SELLING_BOOKS_ARG)) {
                try {
                    externalArgs.setTopSellingBooks(Integer.parseInt(arg.replace(TOP_SELLING_BOOKS_ARG, "")));
                } catch (NumberFormatException e) {
                    // If topSellingBooks arg is not a Integer assigning the default to -1 and the computation for topSellingBooks will be ignored
                    externalArgs.setTopSellingBooks(-1);
                }
            } else if (arg.startsWith(TOP_CUSTOMERS_ARG)) {
                try {
                    externalArgs.setTopCustomers(Integer.parseInt(arg.replace(TOP_CUSTOMERS_ARG, "")));
                } catch (NumberFormatException e) {
                    // Same as the above topSellingBooks
                    externalArgs.setTopCustomers(-1);
                }
            } else if (arg.startsWith(SALES_ON_DATE_ARG)) {
                externalArgs.setSaleOnDate(arg.replace(SALES_ON_DATE_ARG, ""));
            }
        }

        return externalArgs;
    }

    // Converts the CSV to Books Array
    public static List<Book> parseCsvToBookList(String filePath) throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.US_ASCII);
        List<Book> bookList = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] parts = line.split(",");
            Book book = new Book();
            book.setId(parts[0]);
            book.setTitle(parts[1]);
            book.setAuthor(parts[2]);
            book.setPrice(parts[3]);
            bookList.add(book);
        }

        return bookList;
    }

    // Converts the CSV to Sale Array
    public static List<Sale> parseCsvToSaleList(String filePath) throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.US_ASCII);
        List<Sale> saleList = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] parts = line.split(",");
            Sale sale = new Sale();
            sale.setDate(parts[0]);
            sale.setEmail(parts[1]);
            sale.setPaymentMethod(parts[2]);
            sale.setItemCount(Integer.parseInt(parts[3]));
            List<Sale.BookSale> bookSaleList = new ArrayList<>();
            // Loops through the extra BookSale list to get the book sales based on quantity
            for (int i = 1; i <= sale.getItemCount(); i++) {
                String[] bookSalesParts = parts[i + 3].split(";");
                Sale.BookSale bookSale = new Sale.BookSale();
                bookSale.setId(bookSalesParts[0]);
                bookSale.setQuantity(Integer.parseInt(bookSalesParts[1]));
                bookSaleList.add(bookSale);
            }
            sale.setBookSales(bookSaleList);
            saleList.add(sale);
        }

        return saleList;
    }
}
