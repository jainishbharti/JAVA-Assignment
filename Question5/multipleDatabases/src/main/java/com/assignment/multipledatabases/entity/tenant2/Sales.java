package com.assignment.multipledatabases.entity.tenant2;

import javax.persistence.*;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer salesId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User userId;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book bookId;

    public Sales() {}

    public Sales(User userId, Book bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}
