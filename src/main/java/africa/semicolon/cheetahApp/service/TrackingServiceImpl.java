package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetahApp.data.exceptions.InvalidPackageIdException;
import africa.semicolon.cheetahApp.data.models.TrackingData;
import africa.semicolon.cheetahApp.data.models.TrackingInformation;
import africa.semicolon.cheetahApp.data.repositories.TrackingInformationRepository;
import africa.semicolon.cheetahApp.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.cheetahApp.utils.ModelMapper;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService{

    private static final TrackingInformationRepository trackingInformationRepository = new TrackingInformationRepositoryImpl();
    private PackageService packageService = new PackageServiceImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
        // verify package id is correct
        var aPackage  = packageService.findMyPackageWith(addTrackingInfoRequest.getPackageId());
        if (aPackage == null) throw new InvalidPackageIdException("Package id is invalid");

        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
        // find previous package info
        Optional<TrackingInformation> optionalInfo = trackingInformationRepository.findByPackageId(addTrackingInfoRequest.getPackageId());


        // if exist add new event and save
        if (optionalInfo.isPresent()) {
            optionalInfo.get().getTrackingData().add(trackingData);
            trackingInformationRepository.save(optionalInfo.get());
        }else {
        // else create new tracking info, add new event and save
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingInformationRepository.save(trackingInformation);
        }
        // convert saved tracking info to a response dto
        // return response dto
        return ModelMapper.map(trackingData, addTrackingInfoRequest);
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingInformationRepository.findByPackageId(packageId).get();
    }
}
