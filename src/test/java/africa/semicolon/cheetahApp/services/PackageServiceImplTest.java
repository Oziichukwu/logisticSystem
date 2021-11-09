package africa.semicolon.cheetahApp.services;

import africa.semicolon.cheetahApp.data.dtos.request.AddPackageRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetahApp.data.exceptions.DuplicatePackageIdException;
import africa.semicolon.cheetahApp.service.PackageService;
import africa.semicolon.cheetahApp.service.PackageServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServiceImplTest {

    PackageService packageService;
    @BeforeEach
    void setUp() {
        packageService = new PackageServiceImpl();

    }

    @AfterEach
    void tearDown() {
        packageService.deleteAllPackages();
    }

    @Test
    void addPackage() {

        AddPackageRequest addPackageRequest = new AddPackageRequest();
        addPackageRequest.setPackageWeight(34.8);
        addPackageRequest.setPackageDescription("3psc of Laptops");
        addPackageRequest.setDeliveryAddress("my home town");
        addPackageRequest.setReceiverPhone("08132345432");
        addPackageRequest.setReceiversName("chinedu");

        AddPackageResponse addPackageResponse = packageService.addPackage(addPackageRequest);
        assertEquals(addPackageResponse.getPackageWeight(), addPackageRequest.getPackageWeight());
        assertEquals(1, packageService.getAllPackages().size());
    }

    public AddPackageResponse addPackageTest(){
        AddPackageRequest addPackageRequest = new AddPackageRequest();
        addPackageRequest.setPackageWeight(34.8);
        addPackageRequest.setPackageDescription("3psc of Laptops");
        addPackageRequest.setDeliveryAddress("my home town");
        addPackageRequest.setReceiverPhone("08132345432");
        addPackageRequest.setReceiversName("chinedu");

        return packageService.addPackage(addPackageRequest);

    }

    @Test
    void duplicatePackageId_ThrowsException(){
        addPackageTest();
        assertThrows(DuplicatePackageIdException.class, () -> addPackageTest());
    }
}