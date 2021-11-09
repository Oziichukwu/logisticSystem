package africa.semicolon.cheetahApp.data.exceptions;

import africa.semicolon.cheetahApp.data.models.TrackingInformation;

import java.util.List;
import java.util.Optional;

public interface TrackingInformationRepository {

    TrackingInformation save(TrackingInformation trackingInformation);
    List<TrackingInformation> findAll();
    void deleteAll();
    Optional<TrackingInformation> findByPackageId(String packageId);
    void delete(String packageId);
    void delete(TrackingInformation trackingInformation);
}
