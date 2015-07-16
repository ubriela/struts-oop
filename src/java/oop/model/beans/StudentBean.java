/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.model.beans;

/**
 *
 * @author PhuongNV
 */
public class StudentBean extends UserBean{
    private int schoolYear;
    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }
    
    
}
