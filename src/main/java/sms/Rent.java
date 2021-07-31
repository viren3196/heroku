package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import org.joda.time.Days;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

@Component
public class Rent {
    public static final String ACCOUNT_SID = "ACd5d3f27d2b6a893f1845b0f90d60f2ec";
    public static final String AUTH_TOKEN = "4f154c805eb1b4198c3980926ba8e563";

    public static final LocalDate grandKickOff = LocalDate.of(2021, Month.JULY, 21);
    public static final LocalDate grandFinale = LocalDate.of(2021, Month.OCTOBER, 19);

    public static final String dayRemainder = "0 0 8 * * ?";
    public static final String nightRemainder = "0 0 21 * * ?";
    public static final String testRemainder = "0 * * ? * *";

    @Scheduled(cron = dayRemainder)
    public void abcd(){
        LocalDate today = LocalDate.now();
        long daysCompleted = ChronoUnit.DAYS.between(grandKickOff, today);
        long daysRemaining = ChronoUnit.DAYS.between(today, grandFinale);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+919404932554"),
                new com.twilio.type.PhoneNumber("+16122605568"),
                "Hey Champ! You have successfully completed " + daysCompleted + " days here. Give it the best shot of your life. Everything depends on it. Just " + daysRemaining + " days more to go. ")
                .create();

        System.out.println(message.getSid());
    }

    @Scheduled(cron = nightRemainder)
    public void abcd2(){
        LocalDate today = LocalDate.now();
        long daysCompleted = ChronoUnit.DAYS.between(grandKickOff, today);
        long daysRemaining = ChronoUnit.DAYS.between(today, grandFinale);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+919589268924"),
                new com.twilio.type.PhoneNumber("+16122605568"),
                "Hey Champ! You have successfully completed " + daysCompleted + " days here. Give it the best shot of your life. Everything depends on it. Just " + daysRemaining + " days more to go. ")
                .create();

        System.out.println(message.getSid());
    }
}
