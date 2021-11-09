package africa.semicolon.cheetahApp.data.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class TrackingData {
    private final LocalDateTime localDateTime = LocalDateTime.now();

    @NonNull
    private String event;
}
