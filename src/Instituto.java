import java.util.List;
public class Instituto {
    private int institutoId;
    private String instituto;

    public Instituto (int institutoId, String instituto){
       this.institutoId = institutoId;
       this.instituto = instituto;
    }

    public int getInstitutoID() {
        return institutoId;
    }

    public void setInstitutoID(int institutoId) {
        this.institutoId = institutoId;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
}
