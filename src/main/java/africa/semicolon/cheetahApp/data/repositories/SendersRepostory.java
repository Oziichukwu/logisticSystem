package africa.semicolon.cheetahApp.data.repositories;

import africa.semicolon.cheetahApp.data.models.Sender;

import java.util.List;
import java.util.Optional;

public interface SendersRepostory {

    Sender save (Sender sender);
    Optional<Sender>findSenderByEmail(String email);
    void delete(Sender sender);
    void delete (String senderId);
    void deleteAll();
    List<Sender> findAll();
}
