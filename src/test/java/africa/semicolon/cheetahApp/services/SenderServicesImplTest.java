package africa.semicolon.cheetahApp.services;

import africa.semicolon.cheetahApp.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetahApp.data.exceptions.DuplicateUserException;
import africa.semicolon.cheetahApp.service.SenderServices;
import africa.semicolon.cheetahApp.service.SenderServicesImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SenderServicesImplTest {
    SenderServices senderServices;


    @BeforeEach
    void setUp() {
        senderServices = new SenderServicesImpl();
    }

    @AfterEach
    void tearDown() {
        senderServices.deleteAllSenders();
    }

    @Test
    void registerSender() {

        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Goodnews");
        registerSenderRequest.setSenderEmail("ukaegbu45@gmail.com");
        registerSenderRequest.setPhoneNumber("08134234533");

        RegisterSenderResponse response = senderServices.registerSender(registerSenderRequest);
        assertEquals(response.getSenderEmail(), registerSenderRequest.getSenderEmail());
        assertEquals(1, senderServices.getSenders().size());
    }

    public RegisterSenderResponse registerSenderTest(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Goodnews");
        registerSenderRequest.setSenderEmail("ukaegbu45@gmail.com");
        registerSenderRequest.setPhoneNumber("08134234533");
        return senderServices.registerSender(registerSenderRequest);
    }

    @Test
    void duplicateEmail_throwsException(){
        registerSenderTest();
        assertThrows(DuplicateUserException.class, ()-> registerSenderTest());
    }
}