# book-sale

### Clone the code

```shell
$ git clone https://github.com/Nevedha2212/book-sale.git
```

### Prerequisites
1. Java 8+ should be installed on your system

### Compile the code
```shell
// Navigate to src folder
$ cd src
// Compile all java files
$ javac $(find . -name "*.java")
```

### Run the code
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=30 --top_customers=20 --sales_on_date=2018-09-02
```
*Update the file path correctly, also please make sure your terminal path is in src directory*

### Known Issues
1. Application will throw exception if CSV file has blank line.
2. Application will throw exception if CSV file is not of right format

### Time taken
Total time taken to complete the project took 4 hours.
 - 2 hours to fetch CSV file
 - 1 hour to compute the logic
 - 1 hour to test and document
