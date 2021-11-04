package africa.semicolon.cheetahApp.utils;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.models.Package;

public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setReceiverName(addPackageRequest.getReceiversName());
        aPackage.setSenderName(addPackageRequest.getSendersName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        aPackage.setSenderPhone(addPackageRequest.getSendersPhone());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());

        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){

        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverAddress(savedPackage.getDeliveryAddress());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }
}
