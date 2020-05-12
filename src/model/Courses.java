/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Memento
 */
public class Courses {
    private String courseCode;
    private String numberOfCredits;
    private String courseName;

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the numberOfCredits
     */
    public String getNumberOfCredits() {
        return numberOfCredits;
    }

    /**
     * @param numberOfCredits the numberOfCredits to set
     */
    public void setNumberOfCredits(String numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
