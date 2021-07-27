package com.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String streetName;
    private String streetAddressNumber;
    private String cityName;
    private String state;
    private String postCode;
    private String country;
}
