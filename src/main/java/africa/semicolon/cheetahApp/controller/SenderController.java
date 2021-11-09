package africa.semicolon.cheetahApp.controller;

import africa.semicolon.cheetahApp.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetahApp.data.models.Sender;
import africa.semicolon.cheetahApp.service.SenderServices;
import africa.semicolon.cheetahApp.service.SenderServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
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
