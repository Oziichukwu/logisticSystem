package africa.semicolon.cheetahApp.data.dtos.request;

import lombok.Data;

@Data

public class AddTrackingInfoRequest {

    private Integer packageId;
    private String event;
}
