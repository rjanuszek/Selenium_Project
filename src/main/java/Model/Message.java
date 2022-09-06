package Model;

import Enums.SubjectHeading;
import MainData.DataForTest;
import com.google.gson.internal.bind.util.ISO8601Utils;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.Data;

@Data
public class Message {

    public SubjectHeading subjectHeading;
    public String emailAddress;
    public String orderReference;
    public String textMessage;

    public static void setNewMessage(Message message) {
//        Message message = new Message();
        message.setSubjectHeading(SubjectHeading.CUSTOMER_SERVICE);
        message.setEmailAddress(DataForTest.ADDRESS_EMAIL);
        message.setOrderReference(DataForTest.ORDER_NUMBER);
        message.setTextMessage(DataForTest.TEXT_MESSAGE);
    }
}