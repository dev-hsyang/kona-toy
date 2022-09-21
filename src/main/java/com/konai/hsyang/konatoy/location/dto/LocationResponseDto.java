package com.konai.hsyang.konatoy.location.dto;

import com.konai.hsyang.konatoy.location.domain.Location;
import lombok.Getter;

@Getter
public class LocationResponseDto {

    private Long locationID;
    private Long latitude;
    private Long longtitude;

    public LocationResponseDto(Location entity){
        this.locationID = entity.getLocationID();
        this.latitude = entity.getLatitude();
        this.longtitude = entity.getLongtitude();
    }
}
