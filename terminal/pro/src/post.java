import java.util.ArrayList;

public class post {
    String text;
    user from;
    String about;
    String tejari;
    ArrayList<user> to =new ArrayList<>();
    ArrayList<user> likers =new ArrayList<>();
    ArrayList<comment> comments=new ArrayList<>();


    public post (String text, user from , ArrayList to){
        this.text=text;
        this.from=from;
        this.to=to;
    }
}
