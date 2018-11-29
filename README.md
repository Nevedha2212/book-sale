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

### Few tests
Input 1
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=30 --top_customers=20 --sales_on_date=2018-09-02
```
Output 1
```
top_selling_books       123A    1S45    1S75    1S95

top_customers   joh4n@doe.com   john@doe.com    hi@doe.com      johnny@doe.com  foo@bar.com

sales_on_date   2018-09-02      92.88
```

Input 2
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=3 --top_customers=2 --sales_on_date=2018-09-02
```
Output 2
```
top_selling_books       123A    1S45    1S75

top_customers   joh4n@doe.com   john@doe.com

sales_on_date   2018-09-02      92.88
```

Input 3
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=30 --top_customers=20
```
Output 3
```
top_selling_books       123A    1S45    1S75    1S95

top_customers   joh4n@doe.com   john@doe.com    hi@doe.com      johnny@doe.com  foo@bar.com
```

Input 4
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=5 --sales_on_date=2018-09-02
```
Output 4
```
top_selling_books       123A    1S45    1S75    1S95

sales_on_date   2018-09-02      92.88
```

Input 5
```shell
$ java com/book/sale/Driver --books=/Users/nevedha/Projects/BookSale/asset/books.list --sales=/Users/nevedha/Projects/BookSale/asset/sales.list --top_selling_books=1 --sales_on_date=2018-09-02
```
Output 5
```
top_selling_books       123A

sales_on_date   2018-09-02      92.88
```


### Known Issues
1. Application will throw exception if CSV file has blank line.
2. Application will throw exception if CSV file is not of right format

### Time taken
Total time taken to complete the project took 5 hours.
 - 2 hours to fetch CSV file
 - 1 hour to compute the logic
 - 2 hour to test and document
