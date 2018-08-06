package actions;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private String name = "Guest";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
