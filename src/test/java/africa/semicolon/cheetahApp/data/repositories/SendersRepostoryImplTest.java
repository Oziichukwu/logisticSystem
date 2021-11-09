package africa.semicolon.cheetahApp.data.repositories;

import africa.semicolon.cheetahApp.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SendersRepostoryImplTest {

    SendersRepostory sendersRepostory;
    @BeforeEach
    void setUp() {
        sendersRepostory = new SendersRepostoryImpl();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void save() {
        Sender sender = new Sender();
        sender.setSenderName("bolu");
        sender.setEmailAddress("uche32@gmail.com");
        sender.setPhoneNumber("08134567898");
        sender.setUsername("goodboyz");

        Sender savedSender = sendersRepostory.save(sender);

        assertEquals(1, sendersRepostory.findAll().size());
        assertEquals(sender, savedSender);
    }

    public Sender saveSender(){
        Sender sender = new Sender();
        sender.setSenderName("bolu");
        sender.setEmailAddress("uche32@gmail.com");
        sender.setPhoneNumber("08134567898");
        sender.setUsername("goodboyz");

        return  sendersRepostory.save(sender);
    }

    @Test
    void findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender,sendersRepostory.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = saveSender();
        sendersRepostory.delete(savedSender.getEmailAddress());
        assertEquals(0, sendersRepostory.findAll().size());
    }

    @Test
    void testDeleteBySender() {
        Sender savedSender = saveSender();
        sendersRepostory.delete(savedSender);
        assertEquals(0, sendersRepostory.findAll().size());
    }

}