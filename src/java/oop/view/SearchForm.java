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

/**
 *
 * @author Nguyen Tien Thanh
 */
public class SearchForm extends ActionForm {
    private String searchStr;
    private int exerciseId;

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        searchStr= "";
    }
}
