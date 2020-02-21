/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMStutorial;
import com.teknikindustries.bulksms.SMS;

/**
 *
 * @author Hamza
 */
public class MessageSMS {

    public MessageSMS() {
        SMS sms=new SMS();
        sms.SendSMS("hamzabalti", "Hamzabalti1997", "Votre enfant a été absent", "21697088480", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
    
    }

    @Override
    public String toString() {
        return "MessageSMS{" + '}';
    }
    
    /**
     *
     */


}
