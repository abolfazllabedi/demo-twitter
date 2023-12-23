
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
      Scanner scanner= new Scanner(System.in);
        ArrayList<user> users = new ArrayList<>();
        ArrayList<group> groups = new ArrayList<>();
        ArrayList<massage> allmassage = new ArrayList<>();
        ArrayList<post> allpost = new ArrayList<>();

        user a11= new user("a","1","r","yes");
        user b11= new user("b","2","g","yes");
        user c11= new user("c","3","b","yes");
        users.add(a11);
        users.add(b11);
        users.add(c11);

        while (true) {
            String input = scanner.nextLine();
          //  String x = input.replaceAll(" ", "");
           // System.out.println(input);

            boolean login=false;
            user online=new user();

            //  end
            //  create new account
            //  print
            //                 forget
            //                 logout
            //                 follow (username)
            //                 unfollow (username)
            //                 print my followers
            //                 print my following
            //  login          create new group
            //                 add (username) to (group name)
            //                 print group members
            //                 send text to (group name)
            //                 group (group name)
            //                 send massage to (username)
            //                 show massage
            //                 send post
            //                 show post
            //                 show post likers
            //                 show post comments
            //                 pv (username)       exit
            //                 suggest
            //                 send ADS
            //                 ADS (about)

            
            if (input.equals("end")) {return;}

            if (input.equals("create new account")) {
                System.out.println("Enter your Username :");
                String ID = scanner.nextLine();

                System.out.println("Enter your Password :");
                String pass1 = scanner.nextLine();
                System.out.println("again Enter your Password :");
                String pass2 = scanner.nextLine();

                while (!(pass1.equals(pass2))){
                    System.out.println("your password is incorrect ,again Enter your Password :");
                     pass2 = scanner.nextLine();
                }
                System.out.println("whats your favorite color ?");
                String hint = scanner.nextLine();

                System.out.println("Is your account commercial?");
                String tegari = scanner.nextLine();


                user a= new user(ID,pass1,hint,tegari);
               users.add(a);

                System.out.println("your account is created!");
            }


            if (input.equals("print")) {
                for (user user : users) {
                 System.out.println(user.UserName +"  "+ user.Password +"  "+ user.business);
                }
            }


            if (input.equals("login")) {
                boolean tr=false;
                System.out.println("Enter your Username :");
                String id = scanner.nextLine();
                for (user user : users) {
                    if(user.UserName.equals(id)) {
                      tr=true;
                    }
                }
       if(tr){
                System.out.println("Enter your Password :");
                String pass = scanner.nextLine();
                if (pass.equals("forget")) {
                    System.out.println("whats your favorite color ?");
                    String hint = scanner.nextLine();
                    for (user user : users) {
                        if(user.UserName.equals(id)) {
                            if (user.ForgetPass.equals(hint)) {
                                System.out.println("your password is :"+user.Password);
                            }
                        }
                    }
                }
                else{
                    for (user user : users) {
                        if(user.UserName.equals(id)) {
                            if(user.Password.equals(pass)){
                                login=true;
                                online=user;
                            }
                         else{
                            System.out.println("username or password is incorrect");
                        }
                    }
                    }
                }

       }
       else{System.out.println("username not found !!");}
            }


            if(login){System.out.println("welcome");}
            while(login){

                String order = scanner.nextLine();
           // System.out.println(online.UserName+"  "+online.Password);
                if (order.equals("logout")) {
                    login=false;
                    System.out.println("goodbye");
                }

                if(order.startsWith("follow")){
                    String[] tnt = order.split(" ");
                  //  System.out.println(tnt[1]);

                    boolean test=true;
                    for (user user : users) {
                       if(tnt[1].equals(user.UserName)) {
                           test=false;
                           online.following.add(user);
                           user.follower.add(online);
                       }
                    }
                    if(test){
                        System.out.println("user "+ tnt[1] +" not found");
                    }
                    else{
                        System.out.println("You have followed "+ tnt[1]);
                    }
                }


                if(order.startsWith("unfollow")){
                    String[] tnt = order.split(" ");
                    //  System.out.println(tnt[1]);

                    boolean test=true;
                    for (user user : users) {
                        if(tnt[1].equals(user.UserName)) {
                            test=false;
                            online.following.remove(user);
                            user.follower.remove(online);
                        }
                    }
                    if(test){
                        System.out.println("user "+ tnt[1] +" not found");
                    }
                    else{
                        System.out.println("You have unfollowed "+ tnt[1]);
                    }
                }


                if(order.startsWith("print my follower")) {
                    System.out.println("follower : ");
                    for (user user : online.follower) {
                        System.out.println(user.UserName);
                    }
                }

                if(order.startsWith("print my following")) {

                            System.out.println("following : ");
                    for (user user : online.following) {
                        System.out.println(user.UserName);
                    }

                    }


                if (order.equals("create new group")) {
                    System.out.println("Enter group name :");
                    String groupName = scanner.nextLine();
                    ArrayList<user> member = new ArrayList<>();
                    member.add(online);
                    group b = new group(groupName,member);
                    groups.add(b);
                    System.out.println("The group was created");
                }


                if (order.startsWith("add ")) { //add b to k      b:user     k:group
                    String[] tnt = order.split(" ");
                    //System.out.println("Enter the group name :");
                    String groupID;
                    //= scanner.nextLine();
                    groupID=tnt[3];
                    for (group group : groups) {
                        if (group.Name.equals(groupID)) {
                            // System.out.println("Enter the username :");
                            String userID ;
                            //= scanner.nextLine();
                            userID=tnt[1];
                            for (user user : users) {
                                if (user.UserName.equals(userID)) {
                                    group.member.add(user);
                                    System.out.println(user.UserName+" successfully added to " +groupID);
                                }
                            }
                        }
                    }
                }


                if (order.equals("print group members")) {
                    System.out.println("Write the name of group :");
                    String groupName = scanner.nextLine();
                    for (group group : groups) {
                        if (group.Name.equals(groupName))
                            for (user user : group.member)
                                System.out.println(user.UserName);
                    }
                }


                if (order.startsWith("send text to ")) {
                    String[] tnt = order.split(" ");
                    System.out.println("type your massage :");
                    String text = scanner.nextLine();

                    for (group group : groups) {
                        if (group.Name.equals(tnt[3])) {
                            post a = new post(text, online, group.member);
                            group.zer.add(a);
                        }
                    }
                }



                if (order.startsWith("group ")){
                    String[] tnt = order.split(" ");

                    for (group group : groups) {
                       if(group.Name.equals(tnt[1])) {
                           for (post post : group.zer) {
                               System.out.println("from "+post.from.UserName+" :");
                               System.out.println(post.text);
                           }
                       }
                    }
                    System.out.println();
                }



                if (order.startsWith("send massage to")){
                    String[] tnt = order.split(" ");
                    System.out.println("type your massage :");
                    String text = scanner.nextLine();
                    for (user user : users) {
                        if(user.UserName.equals(tnt[3])){
                            massage a=new massage(text,online,user);
                            allmassage.add(a);
                            System.out.println("massage sent !");
                        }
                    }

                }


                if (order.equals("show massage")){
                    for (massage massage : allmassage) {
                        if(massage.to.UserName.equals(online.UserName)){
                            System.out.println("from "+massage.from.UserName+" :");
                            System.out.println(massage.text);
                            System.out.println();
                        }
                    }
                }


                if (order.equals("send post")){
                    System.out.println("type your post :");
                    String text = scanner.nextLine();
                    post a = new post(text,online,online.follower);
                    a.tejari="no";
                    a.about="";
                    allpost.add(a);
                    System.out.println("post sent !");
                }


                if (order.equals("show post")){
                    for (post post : allpost) {
                        for (user user : post.to) {
                          if(user.UserName.equals(online.UserName)) {
                              System.out.println("post from "+post.from.UserName+" :");
                              System.out.println(post.text);

                              System.out.println("continue or like and comment ?");
                              String clc = scanner.nextLine();

                             if(clc.equals("like") || clc.equals("comment")){
                              System.out.println("do you like this post ?");
                              String like = scanner.nextLine();
                              if(like.equals("yes")){post.likers.add(online);}

                              if(like.equals("no")) {
                                  for (user liker : post.likers) {
                                      if(liker.UserName.equals(online.UserName)){post.likers.remove(liker);}
                                  }
                              }
                              System.out.println("do you want to write comment for this post ?");
                              String coment = scanner.nextLine();
                              if(coment.equals("yes")){
                                  System.out.println(" write your comment ?");
                                   coment = scanner.nextLine();
                                  comment a=new comment(coment,online,post.to) ;
                                  post.comments.add(a);
                              }
                             }

                          }
                        }
                    }
                }


                if (order.equals("show post likers")){
                    for (post post : allpost) {
                     if(post.from.UserName.equals(online.UserName)) {
                         System.out.println("the ");
                         System.out.println(post.text);
                         System.out.println("liked by :");
                         int i=1;
                         for (user liker : post.likers) {
                             System.out.print(i+", "+liker.UserName+"      ");
                             i++;
                         }
                     }
                    }

                }


                if (order.equals("show post comments")) {
                    for (post post : allpost) {
                        if (post.from.UserName.equals(online.UserName)) {
                            System.out.println("your post : "+post.text);
                            System.out.println("coments :");

                            for (comment comment : post.comments) {
                                System.out.println( comment.from.UserName + " : " + comment.text);
                            }


                        }

                    }
                }




                if (order.startsWith("pv ")){
                    boolean hk=true;
                    String[] tnt = order.split(" ");
                    while(hk){
                        for (massage massage : allmassage) {
                        if(massage.to.UserName.equals(online.UserName) && massage.from.UserName.equals(tnt[1]) ){
                            System.out.println("from "+massage.from.UserName+" :");
                            System.out.println(massage.text);

                        }
                        if(massage.to.UserName.equals(tnt[1]) && massage.from.UserName.equals(online.UserName) ){
                            System.out.println("from you :");
                            System.out.println(massage.text);

                        }
                    }
                        String sa=scanner.nextLine();
                        if(sa.equals("exit")){hk=false;}
                        else{
                            for (user user : users) {
                                if (tnt[1].equals(user.UserName)) {
                                    massage y=new massage(sa,online,user);
                                    allmassage.add(y);
                                }
                            }

                            }
                    }

                    System.out.println();
                }



                if (order.equals("suggest")){
                    System.out.println("suggest for you :");
                    for (user user : users) {
                        boolean nn=true;
                      if(user.equals(online))  {nn=false;}
                      else{

                          for (user user1 : online.following) {
                              if(user1.equals(user)){nn=false;}
                          }
                      }
                      if(nn){
                          System.out.println(user.UserName); }
                    }
                }



                if (order.equals("send ADS")){
                    System.out.println("type your ADS post :");
                    String text = scanner.nextLine();
                    post a = new post(text,online,online.follower);
                    a.tejari="yes";
                    System.out.println("your ADS about ? :");
                    String text1 = scanner.nextLine();
                    a.about=text1;
                    allpost.add(a);
                    System.out.println("post sent !");
                }




                if (order.startsWith("ADS ")){
                    String[] tnt = order.split(" ");
                    for (post post : allpost) {
                     if(post.tejari.equals("yes")){
                         if(post.about.equals(tnt [1])){
                             System.out.println(post.from.UserName+" : ");
                             System.out.println(post.text);
                         }
                     }
                    }
                }









            }

        }
        }
    }