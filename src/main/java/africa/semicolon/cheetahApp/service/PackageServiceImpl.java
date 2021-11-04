package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.models.Package;
import africa.semicolon.cheetahApp.data.repositories.PackageRepository;
import africa.semicolon.cheetahApp.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetahApp.utils.ModelMapper;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository = new PackageRepositoryImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {

        Package aPackage = ModelMapper.map(addPackageRequest);

        Package savedPackage = packageRepository.save(aPackage);

        AddPackageResponse response = ModelMapper.map(savedPackage);

        return response;

    }

    @Override
    public Package findMyPackageWith(Integer id) {
        return packageRepository.findById(id);
    }
}
