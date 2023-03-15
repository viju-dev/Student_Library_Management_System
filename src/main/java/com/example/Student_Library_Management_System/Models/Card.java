package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Card {

    //Plan is to save this card in db.
    //Before saving I have to set its attributes : rule1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Its auto Generated

    @CreationTimestamp //Auto timestamp the time when an entry is created
    private Date createdOn; //Its auto Generated

    @UpdateTimestamp //Sets time when an entry is updated
    private Date updatedOn; // Its Auto Generated

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus; //set this attribute

    @OneToOne
    @JoinColumn
    private Student studentVariableName; //This Variable is used in the parent class
    //while doing the bidirectional mapping

    //Card is parent wrt to Book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

    //connecting the card class to the transaction

    //Connecting the card class to the transaction
    //Bidireectional Mapping
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList = new ArrayList<>();

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

}
