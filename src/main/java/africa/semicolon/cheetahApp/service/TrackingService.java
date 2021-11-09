package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetahApp.data.models.TrackingInformation;

public interface TrackingService {

    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest);

    TrackingInformation trackPackage(Integer packageId);

}
