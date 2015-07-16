/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.view;

import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import java.sql.Date;
import org.apache.struts.upload.FormFile;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author PhuongNV
 */
public class GradeTaskForm extends ActionForm {
    private int exerciseId;
    private String studentId;
    private int score;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String description) {
        this.comment = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
}