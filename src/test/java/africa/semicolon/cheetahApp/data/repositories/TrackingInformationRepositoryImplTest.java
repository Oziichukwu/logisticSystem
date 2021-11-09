package africa.semicolon.cheetahApp.data.repositories;

import africa.semicolon.cheetahApp.data.models.TrackingData;
import africa.semicolon.cheetahApp.data.models.TrackingInformation;
import africa.semicolon.cheetahApp.data.repositories.TrackingInformationRepository;
import africa.semicolon.cheetahApp.data.repositories.TrackingInformationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInformationRepositoryImplTest {

    TrackingInformationRepository trackingInformationRepository;
    @BeforeEach
    void setUp() {
        trackingInformationRepository = new TrackingInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(325322);

        TrackingData trackingData = new TrackingData("Package ready for dispatch");
        trackingData.setEvent("Package");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);

        assertEquals(savedInfo, trackingInformation);
        assertEquals(1, trackingInformationRepository.findAll().size());
    }
    private TrackingInformation saveTestHelper(){

        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(325322);

        TrackingData trackingData = new TrackingData("Package ready for dispatch");
        trackingData.setEvent("Package");
        trackingInformation.getTrackingData().add(trackingData);

        return trackingInformationRepository.save(trackingInformation);
    }


    @Test
    void findAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());

    }

    @Test
    void deleteAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());

        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void findByPackageId() {
       TrackingInformation savedTrackingInformation =  saveTestHelper();
        Optional<TrackingInformation>optionalTrackingInformation = trackingInformationRepository.findByPackageId(savedTrackingInformation.getPackageId());
        assertTrue(optionalTrackingInformation.isPresent());
        assertEquals(savedTrackingInformation, optionalTrackingInformation.get());
    }

    @Test
    void delete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation.getPackageId());
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void testDelete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedTrackingInformation);
        assertEquals(0, trackingInformationRepository.findAll().size());
    }
}