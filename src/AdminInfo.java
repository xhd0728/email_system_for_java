public class AdminInfo{
    String AdminName;
    String AdminPasswd;

    public AdminInfo(){
        this.AdminName = "admin";
        this.AdminPasswd = "admin";
    }

    public void modifyAdminName(String nm){
        this.AdminName = nm;
        System.out.println("modify completed!");
    }

    public void modifyAdminPasswd(String pw){
        this.AdminPasswd = pw;
        System.out.println("modify completed!");
    }

    public void showAdminInfo(){
        System.out.println("admin name     = : " + this.getAdminName());
        System.out.println("admin password = : " + this.getAdminPasswd());
    }

    public String getAdminName(){
        return this.AdminName;
    }

    public String getAdminPasswd(){
        return this.AdminPasswd;
    }
}