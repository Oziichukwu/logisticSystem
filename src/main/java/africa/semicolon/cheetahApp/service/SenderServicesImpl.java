package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetahApp.data.exceptions.DuplicateUserException;
import africa.semicolon.cheetahApp.data.models.Sender;
import africa.semicolon.cheetahApp.data.repositories.SendersRepostory;
import africa.semicolon.cheetahApp.data.repositories.SendersRepostoryImpl;
import africa.semicolon.cheetahApp.utils.SenderModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServicesImpl implements SenderServices{

        private static final SendersRepostory sendersRepostory = new SendersRepostoryImpl();

    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest) {
        Optional<Sender>savedSenderInDb = sendersRepostory.findSenderByEmail(registerSenderRequest.getSenderEmail());
        if (savedSenderInDb.isPresent()) throw new DuplicateUserException(registerSenderRequest.getSenderEmail() + "already exist");

        //convert to sender
       Sender sender = SenderModelMapper.map(registerSenderRequest);


        // save
       Sender savedSender =  sendersRepostory.save(sender);

       // convert sender to dto
       // RegisterSenderResponse response = SenderModelMapper.map(savedSender);

        return SenderModelMapper.map(savedSender);
    }

    @Override
    public List<Sender> getSenders() {
        return sendersRepostory.findAll();
    }

    @Override
    public void deleteAllSenders() {
        sendersRepostory.deleteAll();
    }

    @Override
    public Sender findSenderByEmail(String email) {
        return sendersRepostory.findSenderByEmail(email).get();
    }

}
