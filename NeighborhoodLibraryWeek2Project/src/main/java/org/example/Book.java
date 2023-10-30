package org.example;

public class Book {

    public int id;
    public String isbn;
    public String title;
    public boolean isCheckedOut;
    public String checkedOutTo;

public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo){
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.isCheckedOut = isCheckedOut;
    this.checkedOutTo = checkedOutTo;
}

    //You could do the constructor like this for less typing since you know in the beginning it won't be checked out
    //and it's not checked out to anyone
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name) {
    checkedOutTo = name;
    isCheckedOut = true;
    }

    public void checkIn() {
    checkedOutTo = "";
    isCheckedOut = false;
    }
}
