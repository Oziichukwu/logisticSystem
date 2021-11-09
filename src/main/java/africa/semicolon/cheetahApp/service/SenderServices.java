package africa.semicolon.logisticApplication.services;

import africa.semicolon.logisticApplication.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.Sender;

import java.util.Collection;
import java.util.List;

public interface SenderServices {

    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Sender findSenderByEmail(String email);
}
