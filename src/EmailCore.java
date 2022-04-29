import java.util.ArrayList;
import java.util.List;

public class EmailCore{
    List<MailText> inbox = new ArrayList<>();
    List<MailText> outbox = new ArrayList<>();

    public EmailCore(){
        this.inbox.add(new MailText("welcome to use inbox"));
        this.outbox.add(new MailText("welcome to use outbox"));
    }

    public void modifyInbox(String c){inbox.add(new MailText(c));}
    public void modifyOutbox(String c){outbox.add(new MailText(c));}

    public void getInbox(){
        System.out.println("\t   ****************************************");
        System.out.println("\t                      Inbox                ");
        System.out.println("\t   ****************************************");
        for(MailText mailtext : inbox){
            System.out.println(mailtext.text);
        }
    }

    public void getOutbox(){
        System.out.println("\t   ****************************************");
        System.out.println("\t                      Outbox               ");
        System.out.println("\t   ****************************************");
        for(MailText mailtext : outbox){
            System.out.println(mailtext.text);
        }
    }

    public void clearInbox(){
        inbox.clear();
        inbox.add(new MailText("welcome to use inbox"));
    }

    public void clearOutbox(){
        outbox.clear();
        outbox.add(new MailText("welcome to use outbox"));
    }
}