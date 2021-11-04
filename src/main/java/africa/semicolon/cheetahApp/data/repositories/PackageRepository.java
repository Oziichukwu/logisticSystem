package africa.semicolon.cheetahApp.data.repositories;

import africa.semicolon.cheetahApp.data.models.Package;

import java.util.List;

public interface PackageRepository {

    Package save(Package aPackage);
    List<Package> findAll();
    void delete(Package aPackage);
    void delete(Integer trackingNumber);
    Package findById(Integer id);
}
