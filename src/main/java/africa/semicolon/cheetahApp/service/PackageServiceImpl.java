package africa.semicolon.cheetahApp.service;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.exceptions.SenderDoesNotExistException;
import africa.semicolon.cheetahApp.data.models.Package;
import africa.semicolon.cheetahApp.data.models.Sender;
import africa.semicolon.cheetahApp.data.repositories.PackageRepository;
import africa.semicolon.cheetahApp.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetahApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PackageServiceImpl implements PackageService {
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderServices senderServices = new SenderServicesImpl();
    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {

        Optional<Sender> senderOptional = senderServices.findSenderByEmail(addPackageRequest.getSenderEmail());
        if (senderOptional.isEmpty()) throw  new SenderDoesNotExistException("Sender not Registered");
        Package aPackage = ModelMapper.map(addPackageRequest);

        Package savedPackage = packageRepository.save(aPackage);

        return ModelMapper.map(savedPackage);
    }

    @Override
    public Package findMyPackageWith(Integer id) {
        return packageRepository.findById(id);
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public void deleteAllPackages() {

        packageRepository.deleteAll();
    }
}
