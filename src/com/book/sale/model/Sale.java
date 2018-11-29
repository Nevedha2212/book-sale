package com.book.sale.model;

import java.util.List;

public class Sale {

    private String date;
    private String email;
    private String paymentMethod;
    private int itemCount;
    private List<BookSale> bookSales;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<BookSale> getBookSales() {
        return bookSales;
    }

    public void setBookSales(List<BookSale> bookSales) {
        this.bookSales = bookSales;
    }

    static public class BookSale {

        private String id;
        private int quantity;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
