package Model;

import Enums.SubjectHeading;
import MainData.DataForTest;
import lombok.Data;

@Data
public class Message {

    public SubjectHeading subjectHeading;
    public String emailAddress;
    public String orderReference;
    public String textMessage;

    public static void setUpDataForMessage() {
        Message data = new Message();
        data.setSubjectHeading(SubjectHeading.CUSTOMER_SERVICE);
        data.setEmailAddress(DataForTest.ADDRESS_EMAIL);
        data.setOrderReference(DataForTest.ORDER_NUMBER);
        data.setTextMessage(DataForTest.TEXT_MESSAGE);
    }
}