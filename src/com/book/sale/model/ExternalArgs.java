package com.book.sale.model;

public class ExternalArgs {
    private String bookPath = null;
    private String salesPath = null;
    private int topSellingBooks = -1;
    private int topCustomers = -1;
    private String saleOnDate = null;

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public String getSalesPath() {
        return salesPath;
    }

    public void setSalesPath(String salesPath) {
        this.salesPath = salesPath;
    }

    public int getTopSellingBooks() {
        return topSellingBooks;
    }

    public void setTopSellingBooks(int topSellingBooks) {
        this.topSellingBooks = topSellingBooks;
    }

    public int getTopCustomers() {
        return topCustomers;
    }

    public void setTopCustomers(int topCustomers) {
        this.topCustomers = topCustomers;
    }

    public String getSaleOnDate() {
        return saleOnDate;
    }

    public void setSaleOnDate(String saleOnDate) {
        this.saleOnDate = saleOnDate;
    }
}
