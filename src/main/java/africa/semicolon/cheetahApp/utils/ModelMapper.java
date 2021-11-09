package africa.semicolon.cheetahApp.utils;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetahApp.data.models.Package;
import africa.semicolon.cheetahApp.data.models.TrackingData;

public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setReceiverName(addPackageRequest.getReceiversName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());

        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){

        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }

    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfo) {

        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setLocalDateTime(trackingData.getLocalDateTime());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setPackageId(addTrackingInfo.getPackageId());

        return addTrackingInfoResponse;
    }
//
//    public static TrackingData map(AddTrackingInfoRequest addTrackingInfoRequest){
//        TrackingData trackingData = new TrackingData();
//        return trackingData;
//    }
//
//    public static AddTrackingInfoRequest map (TrackingData savedTrackingData){
//
//        AddTrackingInfoResponse response = new AddTrackingInfoResponse();
//
//        return response;
//    }
}
