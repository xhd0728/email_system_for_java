public class UserInfo extends EmailCore{
    String userName;
    String userPasswd;
    String email;
    String phoneNum;

    public UserInfo(){
        super();
        this.userName = "normal";
        this.userPasswd = "normal";
        this.email = "normal";
        this.phoneNum = "normal";
    }
     
    public void setName(String nm){this.userName = nm;}
    public void setPasswd(String pw){this.userPasswd = pw;}
    public void setEmail(String em){this.email = em;}
    public void setPhoneNum(String tel){this.phoneNum = tel;}

    public String getName(){return this.userName;}
    public String getPasswd(){return this.userPasswd;}
    public String getEmail(){return this.email;}
    public String getPhoneNum(){return this.phoneNum;}
}