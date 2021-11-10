package africa.semicolon.cheetahApp.controller;


import africa.semicolon.cheetahApp.data.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetahApp.data.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetahApp.data.models.TrackingInformation;
import africa.semicolon.cheetahApp.service.TrackingService;
import africa.semicolon.cheetahApp.service.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PostMapping("/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo/{id}")
    public TrackingInformation getTrackingInfo(@PathVariable ("id") Integer trackingId){

        return trackingService.trackPackage(trackingId);
    }
}
