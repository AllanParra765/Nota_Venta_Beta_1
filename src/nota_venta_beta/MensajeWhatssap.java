package nota_venta_beta;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MensajeWhatssap {
  // Replace these constants with your own account SID and auth token
  // and WhatsApp sandbox phone number
  public static final String ACCOUNT_SID = "ACb6e229509c7917e0a54a1b4d1caff8ae";
  public static final String AUTH_TOKEN = "ba0c1299083f7e12162bf7a6eedb38d0";
  public static final String SANDBOX_PHONE_NUMBER = "whatsapp:+5214772307241";

  public static void main(String[] args) {
    // Initialize the Twilio client
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    // Send the message to the WhatsApp sandbox number
    Message message = Message.creator(new PhoneNumber(SANDBOX_PHONE_NUMBER),
        new PhoneNumber(SANDBOX_PHONE_NUMBER),
        "This is a test message from the WhatsApp Business API sandbox.")
        .create();

    
    
    System.out.println(message.getSid());
  }
}
