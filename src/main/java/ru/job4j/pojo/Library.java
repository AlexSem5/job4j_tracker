package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Story", 150);
        Book book2 = new Book("Short Story", 50);
        Book book3 = new Book("Long Story", 550);
        Book book4 = new Book("Clean Code", 555);
        Book[] myBooks = new Book[4];
        myBooks[0] = book1;
        myBooks[1] = book2;
        myBooks[2] = book3;
        myBooks[3] = book4;
        for (int i = 0; i < myBooks.length; i++) {
            Book b = myBooks[i];
            System.out.println(b.getName() + " - " + b.getNumOfPages());
        }
        Book temp = myBooks[0];
        myBooks[0] = myBooks[3];
        myBooks[3] = temp;
        for (Book book : myBooks) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumOfPages());
            }
        }

    }
}
