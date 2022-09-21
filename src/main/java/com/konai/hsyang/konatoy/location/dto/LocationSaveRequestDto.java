package com.konai.hsyang.konatoy.location.dto;

import com.konai.hsyang.konatoy.location.domain.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LocationSaveRequestDto {

    private Long latitude;
    private Long longtitude;

    @Builder
    public LocationSaveRequestDto(Long lat, Long lng) {
        this.latitude = lat;
        this.longtitude = lng;
    }

    public Location toEntity(){
        return Location.builder()
                .latitude(latitude)
                .longtitude(longtitude)
                .build();
    }
}
