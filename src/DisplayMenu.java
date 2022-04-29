import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DisplayMenu{

    public static void initWel(){
        SysDate.showDate();
        System.out.println("\tCopyright Catalina_xin");
        System.out.println(" ");
        System.out.println("\t*******************************");
        System.out.println("\t*                             *");
        System.out.println("\t*            MENU             *");
        System.out.println("\t*                             *");
        System.out.println("\t*  please input your option:  *");
        System.out.println("\t*                             *");
        System.out.println("\t*  1.login                    *");
        System.out.println("\t*                             *");
        System.out.println("\t*  2.register                 *");
        System.out.println("\t*                             *");
        System.out.println("\t*  3.admin-login              *");
        System.out.println("\t*                             *");
        System.out.println("\t*  0.exit the program         *");
        System.out.println("\t*                             *");
        System.out.println("\t*******************************");
    }

    public static void initAdminSet(){
        SysDate.showDate();
        System.out.println("\tCopyright Catalina_xin");
        System.out.println(" ");
        System.out.println("\t***********************************");
        System.out.println("\t*                                 *");
        System.out.println("\t*           ADMIN MENU            *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  1.modify admin name            *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  2.modify admin passwd          *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  3.list users info              *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  4.import user list from file   *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  5.show admin information       *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  6.clear system log             *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  7.delete user                  *");
        System.out.println("\t*                                 *");
        System.out.println("\t*  0.<-admin logout               *");
        System.out.println("\t*                                 *");
        System.out.println("\t***********************************");
    }

    public static void initUserSet(){
        SysDate.showDate();
        System.out.println("\tCopyright Catalina_xin");
        System.out.println(" ");
        System.out.println("\t********************************************************************");
        System.out.println("\t*                             USER MENU                            *");
        System.out.println("\t*                                                                  *");
        System.out.println("\t*  1 .modify user name            |     6 .view inbox              *");
        System.out.println("\t*                                 |                                *");
        System.out.println("\t*  2 .modify user passwd          |     7 .view outbox             *");
        System.out.println("\t*                                 |                                *");
        System.out.println("\t*  3 .modify user phone number    |     8 .clear inbox             *");
        System.out.println("\t*                                 |                                *");
        System.out.println("\t*  4 .show user information       |     9 .clear outbox            *");
        System.out.println("\t*                                 |                                *");
        System.out.println("\t*  5 .send email                  |     10. account cancellation   *");
        System.out.println("\t*                                                                  *");
        System.out.println("\t*                            0.<-logout                            *");
        System.out.println("\t*                                                                  *");
        System.out.println("\t********************************************************************");
    }

    public static void writeLog(String m) throws IOException{
        try{
            File file = new File("syslog.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter filewriter = new FileWriter(file.getName(), true);
            filewriter.write(SysDate.getDate());
            filewriter.write(" : ");
            filewriter.write(m);
            filewriter.write("\n");
            filewriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}