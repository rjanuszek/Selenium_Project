package Model;

import Enums.SubjectHeading;
import lombok.Data;

@Data
public class Message {

    private SubjectHeading subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String textMessage;
}