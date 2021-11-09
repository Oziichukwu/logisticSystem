package africa.semicolon.cheetahApp.data.dtos.request;

import lombok.Data;

@Data
public class RegisterSenderRequest {

    private String senderName;
    private String phoneNumber;
    private String senderEmail;
}
