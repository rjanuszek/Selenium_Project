package Model;

import lombok.Data;

@Data
public class DataForLogin {

    private String firstName;
    private String lastName;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String company;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String postalCode;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
}