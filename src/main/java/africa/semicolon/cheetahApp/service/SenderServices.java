package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetahApp.data.models.Sender;

import java.util.List;
import java.util.Optional;

public interface SenderServices {

    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Optional<Sender> findSenderByEmail(String email);
}
