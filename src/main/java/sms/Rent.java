package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Rent {
    public static final String ACCOUNT_SID = "ACd5d3f27d2b6a893f1845b0f90d60f2ec";
    public static final String AUTH_TOKEN = "4f154c805eb1b4198c3980926ba8e563";

    @Scheduled(fixedRate = 10000)
    public void abc(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+919404932554"),
                new com.twilio.type.PhoneNumber("+16122605568"),
                "This is the ship that made the Kessel Run in fourteen parsecs?")
                .create();

        System.out.println(message.getSid());
    }
}
