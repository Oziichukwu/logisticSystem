package africa.semicolon.cheetahApp.data.exceptions;

import africa.semicolon.cheetahApp.data.models.TrackingInformation;

import java.util.List;
import java.util.Optional;

public class TrackingInformationRepositoryImpl implements TrackingInformationRepository{

    @Override
    public TrackingInformation save(TrackingInformation trackingInformation) {
        return null;
    }

    @Override
    public List<TrackingInformation> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<TrackingInformation> findByPackageId(String packageId) {
        return Optional.empty();
    }

    @Override
    public void delete(String packageId) {

    }

    @Override
    public void delete(TrackingInformation trackingInformation) {

    }
}
