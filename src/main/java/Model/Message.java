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

}