package africa.semicolon.cheetahApp.data.repositories;

import africa.semicolon.cheetahApp.data.models.Package;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {

    PackageRepository packageRepository;
    @BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveNewPackage() {
        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());

    }


    @Test
    void updatePackageTest() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");


        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, savedPackage.getId());
    }


    @Test
    void findAll() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");


        Package savedPackage = packageRepository.save(aPackage);

        assertEquals(1, packageRepository.findAll().size());

    }

    @Test
    void delete() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");


        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(savedPackage);
        assertEquals(0,packageRepository.findAll().size());
    }

    @Test
    void deleteByTrackingNumber() {
        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");


        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(1);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void findPackageTrackingNumber() {
        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setReceiverName("Moses");
        aPackage.setReceiverPhone("08100856612");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Yaba Lagos");
        aPackage.setNetWeight(32.6);
        aPackage.setSenderEmail("ukaegbugoodnews13@gmail.com");


        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(savedPackage, packageRepository.findById(savedPackage.getId()));
    }
}