package africa.semicolon.cheetahApp.data.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddTrackingInfoResponse {
    private Integer packageId;
    private LocalDateTime localDateTime;
    private String event;
}
