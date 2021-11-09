package africa.semicolon.logisticApplication.controller;

import africa.semicolon.logisticApplication.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.logisticApplication.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.logisticApplication.data.models.Sender;
import africa.semicolon.logisticApplication.services.SenderServices;
import africa.semicolon.logisticApplication.services.SenderServicesImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SenderController {
    private final SenderServices senderServices = new SenderServicesImpl();

    @PostMapping("/api/v1/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest){

        return senderServices.registerSender(registerSenderRequest);
    }
    @GetMapping("/api/sender/{email}")
    public Sender findSenderByEmail(@PathVariable String email){

        return senderServices.findSenderByEmail(email);
    }
}
