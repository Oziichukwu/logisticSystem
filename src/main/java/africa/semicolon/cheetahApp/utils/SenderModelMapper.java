package africa.semicolon.logisticApplication.utils;

import africa.semicolon.logisticApplication.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.Sender;

public class SenderModelMapper {


    public static Sender map (RegisterSenderRequest registerSenderRequest){

        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());

        return sender;
    }

    public static RegisterSenderResponse map(Sender savedSender){

        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(savedSender.getEmailAddress());

        return response;
    }
}
