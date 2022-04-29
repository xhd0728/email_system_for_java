import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static AdminInfo A = new AdminInfo();
    static List<UserInfo> T = new ArrayList<>();

    public static void deleteUser(int mm){
        Iterator<UserInfo> iterator = T.iterator();
        while(iterator.hasNext()){
            UserInfo uInfo = iterator.next();
            if(uInfo.getName().equals(T.get(mm).getName())){
                iterator.remove();
                return;
            }
        }
    }

    public static void listInfo(){
        int len = T.size();
        SysDate.showDate();
        System.out.println("\tCopyright Catalina_xin");
        System.out.println(" ");
        System.out.println("\t********************************************************************************************************");
        System.out.println("\t                                            Information Table                                           ");
        System.out.println("\t********************************************************************************************************");
        System.out.println("\t   *[admin]: name     = " + A.getAdminName());
        System.out.println("\t   *[admin]: password = " + A.getAdminPasswd());
        System.out.println("\t********************************************************************************************************");
        System.out.println("id, name, passwd, email, phone number");
        if(len == 0){
            System.out.println("no users");
            return;
        }
        for(UserInfo us : T){
            System.out.println(us.getName() + ", " + us.userPasswd + ", " + us.getEmail() + ", " + us.getPhoneNum());
        }
        System.out.println("\t********************************************************************************************************");
    }
    
    public static void freadUserList() throws IOException{
        T.clear();
        //not yet complete.
        try {
            BufferedReader in = new BufferedReader(new FileReader("userlist.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                UserInfo user = new UserInfo();
                String s[] = str.split(" ");
                String nm = s[0];
                String pw = s[1];
                String em = s[2];
                String tel = s[3];
                user.setName(nm);
                user.setPasswd(pw);
                user.setEmail(em);
                user.setPhoneNum(tel);
                T.add(user);
            }
        } catch (IOException e) {
        }
        System.out.println("read successful");
        // s.close();
        DisplayMenu.writeLog("[admin]: read userlist");
    }

    public static void adminWork() throws IOException{
        while(true){
            DisplayMenu.initAdminSet();
            String op;
            Scanner scanner = new Scanner(System.in);
            op = scanner.next();
            // scanner.close();
            if(op.equals("1")){
                System.out.println("please input new admin name");
                String nm;
                Scanner scanner2 = new Scanner(System.in);
                nm = scanner2.next();
                // scanner2.close();
                A.modifyAdminName(nm);
                DisplayMenu.writeLog("[admin]: update admin name");
            }
            else if(op.equals("2")){
                System.out.println("please input new admin password");
                String pw;
                Scanner scanner3 = new Scanner(System.in);
                pw = scanner3.next();
                // scanner3.close();
                A.modifyAdminPasswd(pw);
                DisplayMenu.writeLog("[admin]: update admin password");
            }
            else if(op.equals("3")){
                listInfo();
            }
            else if(op.equals("4")){
                freadUserList();
            }
            else if(op.equals("5")){
                A.showAdminInfo();
                DisplayMenu.writeLog("[admin]: view admin info");
            }
            else if(op.equals("6")){
                System.out.println("please input \" yes \" to continue");
                String _op;
                Scanner scanner6 = new Scanner(System.in);
                _op = scanner6.next();
                // scanner6.close();
                if(_op.equals("yes")){
                    System.out.println("clear system log successful");
                    DisplayMenu.writeLog("[admin]: clear the system info");
                }
                else{
                    continue;
                }
            }
            else if(op.equals("7")){
                String tpn;
                System.out.println("please input the name you will delete");
                Scanner scanner7 = new Scanner(System.in);
                tpn = scanner7.next();
                // scanner7.close();
                int len = T.size();
                for(int i = 0; i < len; ++i){
                    if(T.get(i).getName().equals(tpn)){
                        deleteUser(i);
                        DisplayMenu.writeLog("[admin]: delete a user");
                        System.out.println("delete successful");
                        return;
                    }
                }
                System.out.println("cannot find this user");
                continue;
            }
            else if(op.equals("0")){
                return;
            }
            else{
                System.out.println("input is wrong, please input 0 ~ 7");
            }
        }
    }

    public static void adminLogin() throws IOException{
        String tpn, tpp;
        while(true){
            System.out.println("please input admin name and password");
            Scanner tpnScanner = new Scanner(System.in);
            Scanner tppScanner = new Scanner(System.in);
            // tpnScanner.close();
            // tppScanner.close();
            tpn = tpnScanner.next();
            tpp = tppScanner.next();
            if(!tpn.equals(A.getAdminName()) || !tpp.equals(A.getAdminPasswd())){
                System.out.println("admin name or password is wrong");
                System.out.println("input \'y\' to try again or any other key to cancel");
                DisplayMenu.writeLog("admin login failed");
                String op;
                Scanner opScanner = new Scanner(System.in);
                // opScanner.close();
                op = opScanner.next();
                if(op.equals("y") || op.equals("Y")){
                    continue;
                }
                else{
                    return;
                }
            }
            break;
        }
        System.out.println("admin login successful");
        DisplayMenu.writeLog("[admin]: login");
        adminWork();
    }

    public Main() {
    }

    public static void saveUserInfo(String nm, String pw, String em, String tel) throws IOException{
        try{
            File file = new File("userlist.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter filewriter = new FileWriter(file.getName(), true);
            filewriter.write(nm + " " + pw + " " + em + " " + tel);
            filewriter.write("\n");
            filewriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("save successful");
        DisplayMenu.writeLog("add a new user");
    }

    public static void isEmailSame(String a, boolean b){
        int len = T.size();
        for (int i = 0; i < len; ++i) {
            if(T.get(i).getEmail().equals(a)){
                b = false;
                return;
            }
        }
    }

    public static void userReg() throws IOException{
        UserInfo p = new UserInfo();
        String nm, pw, em, tel;
        System.out.println("please input username, password, email and phone number");
        Scanner nmScanner = new Scanner(System.in);
        Scanner pwScanner = new Scanner(System.in);
        Scanner emScanner = new Scanner(System.in);
        Scanner telScanner = new Scanner(System.in);
        nm = nmScanner.next();
        pw = pwScanner.next();
        em = emScanner.next();
        tel = telScanner.next();
        // nmScanner.close();
        // pwScanner.close();
        // emScanner.close();
        // telScanner.close();
        boolean fg = true;
        isEmailSame(em, fg);
        if(fg == false){
            System.out.println("the email have been used");
            return;
        }
        else{
            p.setName(nm);
            p.setPasswd(pw);
            p.setEmail(em);
            p.setPhoneNum(tel);
            T.add(p);
            System.out.println("create successful!");
            saveUserInfo(nm, pw, em, tel);
        }
    }

    public static void sendCore(int mm) throws IOException{
        System.out.println("please input the email address who you want to send to");
        String _em;
        Scanner scanner = new Scanner(System.in);
        _em = scanner.next();
        // scanner.close();
        int len = T.size();
        if(len == 0){
            System.out.println("no users");
            return;
        }
        int t = -1;
        for(int i = 0; i < len; ++i){
            if(T.get(i).getEmail().equals(_em)){
                t = i;
                break;
            }
        }
        if(t == -1){
            System.out.println("cannot find this user");
            DisplayMenu.writeLog("a user try to send an email but the receiver is not exist");
            return;
        }
        System.out.println("please input the main text");
        String tx;
        Scanner scanner2 = new Scanner(System.in);
        tx = scanner2.nextLine();
        // scanner2.close();
        System.out.println("do you want to send this text");
        System.out.println("input \'y\' to send or any other key to cancel");
        String _op;
        Scanner scanner3 = new Scanner(System.in);
        _op = scanner3.next();
        // scanner3.close();
        if(_op.equals("y") || _op.equals("Y")){
            System.out.println("send successful");
            DisplayMenu.writeLog("a user have sent an email");
            String tp = "from" + T.get(mm).getEmail() + " " + tx;
            String fp = "tp" + T.get(t).getEmail() + " " + tx;
            T.get(t).modifyInbox(tp);
            T.get(mm).modifyOutbox(fp);
            return;
        }
        else{
            System.out.println("canceled");
            DisplayMenu.writeLog("send canceled");
            return;
        }
    }

    public static void viewInbox(int mm){T.get(mm).getInbox();}
    public static void viewOutbox(int mm){T.get(mm).getOutbox();}

    public static void userWork(int mm) throws IOException{
        while(true){
            DisplayMenu.initUserSet();
            String op;
            Scanner scanner = new Scanner(System.in);
            op = scanner.next();
            // scanner.close();
            if(op.equals("1")){
                System.out.println("please input new user name");
                String nm;
                Scanner scanner2 = new Scanner(System.in);
                nm = scanner2.next();
                // scanner2.close();
                T.get(mm).setName(nm);
                DisplayMenu.writeLog("a user has modified his name");
            }
            else if(op.equals("2")){
                System.out.println("please input new user password");
                String pw;
                Scanner scanner3 = new Scanner(System.in);
                pw = scanner3.next();
                // scanner3.close();
                T.get(mm).setPasswd(pw);
                DisplayMenu.writeLog("a user has modified his password");
            }
            else if(op.equals("3")){
                System.out.println("please input new user phone number");
                String tel;
                Scanner scanner4 = new Scanner(System.in);
                tel = scanner4.next();
                // scanner4.close();
                T.get(mm).setPhoneNum(tel);
                DisplayMenu.writeLog("a user has modified his phone number");
            }
            else if(op.equals("4")){
                System.out.println("User Information\n\n");
                System.out.println("username     = " + T.get(mm).getName() + "\n\n");
                System.out.println("password     = " + T.get(mm).getPasswd() + "\n\n");
                System.out.println("email        = " + T.get(mm).getEmail() + "\n\n");
                System.out.println("phone number = " + T.get(mm).getPhoneNum() + "\n\n");
                DisplayMenu.writeLog("a user has viewed his information");
            }
            else if(op.equals("5")){
                sendCore(mm);
            }
            else if(op.equals("6")){
                viewInbox(mm);
            }
            else if(op.equals("7")){
                viewOutbox(mm);
            }
            else if(op.equals("8")){
                T.get(mm).clearInbox();
                System.out.println("clear successful");
                DisplayMenu.writeLog("a user has cleared his inbox");
            }
            else if(op.equals("9")){
                T.get(mm).clearOutbox();
                System.out.println("clear successful");
                DisplayMenu.writeLog("a user has cleared his outbox");
            }
            else if(op.equals("10")){
                System.out.println("please comfirm your password");
                String tpp;
                Scanner tppScanner = new Scanner(System.in);
                tpp = tppScanner.next();
                // tppScanner.close();
                if(T.get(mm).getPasswd().equals(tpp)){
                    deleteUser(mm);
                    DisplayMenu.writeLog("a user delete his account");
                    return;
                }
                else{
                    System.out.println("password is wrong");
                }
            }
            else if(op.equals("0")){
                return;
            }
            else{
                System.out.println("input error, please input 0 ~ 9");
            }
        }
    }

    public static void userLogin() throws IOException{
        while(true){
            String tpn, tpp;
            System.out.println("please input yor name and password");
            Scanner nScanner = new Scanner(System.in);
            Scanner pScanner = new Scanner(System.in);
            tpn = nScanner.next();
            tpp = pScanner.next();
            // nScanner.close();
            // pScanner.close();
            int len = T.size();
            if(len == 0){
                System.out.println("no users!");
                return;
            }
            for (int i = 0; i < len; i++) {
                if(T.get(i).getName().equals(tpn) && T.get(i).getPasswd().equals(tpp)){
                    System.out.println("login successful");
                    DisplayMenu.writeLog("a user login");
                    userWork(i);
                    return;
                }
            }
            System.out.println("login error, do you want try again?");
            System.out.println("input 'y' to continue or 'n' to back");
            DisplayMenu.writeLog("someone try to login but has input wrong username or password");
            String op;
            Scanner scanner = new Scanner(System.in);
            op = scanner.next();
            // scanner.close();
            if(op.equals("Y") || op.equals("y")){
                continue;
            }
            else{
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DisplayMenu.writeLog("prgram start!");
        String op;
        while(true){
            DisplayMenu.initWel();
            Scanner scanner = new Scanner(System.in);
            op = scanner.next();
            // scanner.close();
            if(op.equals("0")){
                System.out.println("thanks for using!");
                DisplayMenu.writeLog("process shutdown!");
                System.exit(0);
            }
            else if(op.equals("1")){
                userLogin();
            }
            else if(op.equals("2")){
                userReg();
            }
            else if(op.equals("3")){
                adminLogin();
            }
            else{
                System.out.println("input error, please input again");
            }
        }
    }
}
