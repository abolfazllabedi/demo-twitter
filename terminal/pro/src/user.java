import java.util.ArrayList;


public class user {
    String UserName;
    String Password;
    String ForgetPass;
    String business;

    ArrayList<user> follower=new ArrayList<>();
    ArrayList<user> following=new ArrayList<>();

    public user (String UserName,String Password,String ForgetPass,String business){
this.UserName=UserName;
this.Password=Password;
this.ForgetPass=ForgetPass;
this.business=business;
    }
    public user (){
        this.UserName=UserName;
        this.Password=Password;
        this.ForgetPass=ForgetPass;
        this.business=business;
    }
}
