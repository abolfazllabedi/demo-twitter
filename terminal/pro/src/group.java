
import java.util.ArrayList;
public class group {
    String Name;
    ArrayList<user> member ;
    ArrayList<post> zer =new ArrayList<>();

    public group(String Name,ArrayList<user> member){
        this.Name = Name;
        this.member = member;
    }
}