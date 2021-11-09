package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.models.Package;

import java.util.List;

public interface PackageService {


    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWith(Integer id);

    List<Package> getAllPackages();

    void deleteAllPackages();
}
