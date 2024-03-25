package com.encore.bbabap.domain;

import com.encore.bbabap.domain.ChargingStation;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class ChargingStations {
    private List<ChargingStation> stations;

    @XmlElement(name = "item")
    public List<ChargingStation> getStations() {
        return stations;
    }

    public void setStations(List<ChargingStation> stations) {
        this.stations = stations;
    }
}
