/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.model.beans;


/**
 *
 * @author PhuongNV
 */
public class TeacherBean extends UserBean {
    private String diploma;
    private String school;
    private String department;
    
    public TeacherBean(){
        super();
        diploma="";
        school="";
        department="";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
}
