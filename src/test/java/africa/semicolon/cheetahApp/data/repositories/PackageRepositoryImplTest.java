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
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone("08100846657");

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    void updatePackageTest() {
        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("iPhone");
        savedPackage.setReceiverName("uloaku");

        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    void findAll() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());
    }

    @Test
    void delete() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(aPackage);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void testDelete() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(1);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void testFindById() {

        Package aPackage = new Package();
        aPackage.setName("Television");
        aPackage.setSenderName("peter");
        aPackage.setReceiverName("moses");
        aPackage.setDeliveryAddress("312 Herbert Macualey Way Sabo Lagos");
        aPackage.setNetWeight(23.8);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);

        assertEquals(savedPackage, packageRepository.findById(1));
    }
}