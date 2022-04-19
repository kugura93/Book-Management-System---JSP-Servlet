/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HLC
 */
public class BookCase {
    private int bookCaseId;
    private String bookCaseName;
    
    public BookCase(){
        
    }

    public BookCase(int bookCaseId, String bookCaseName) {
        this.bookCaseId = bookCaseId;
        this.bookCaseName = bookCaseName;
    }

    public int getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(int bookCaseId) {
        this.bookCaseId = bookCaseId;
    }

    public String getBookCaseName() {
        return bookCaseName;
    }

    public void setBookCaseName(String bookCaseName) {
        this.bookCaseName = bookCaseName;
    }
    
    
}
