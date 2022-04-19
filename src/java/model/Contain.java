/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author HLC
 */
public class Contain {
    private int bookCaseId;
    private int bookId;
    private Date createDate;

    public Contain(int bookCaseId, int bookId, Date createDate) {
        this.bookCaseId = bookCaseId;
        this.bookId = bookId;
        this.createDate = createDate;
    }

    public int getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(int bookCaseId) {
        this.bookCaseId = bookCaseId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
}
