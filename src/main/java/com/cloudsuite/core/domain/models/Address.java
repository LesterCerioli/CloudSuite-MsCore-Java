package com.cloudsuite.core.domain.models;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Address extends Entity implements IAggregateRoot {
    private final List<District> districts = new ArrayList<>();
    private final List<City> cities = new ArrayList<>();
    private String contactName;
    private String addressLine1;
    private City city;
    private UUID cityId;
    private District district;
    private UUID districtId;

    public Address(UUID id, City city, District district, String contactName, String addressLine1) {
        //Id = id;
        this.city = city;
        this.district = district;
        this.contactName = contactName;
        this.addressLine1 = addressLine1;
    }

    public Address(UUID id, String contactName, String addressLine1) {
        //Id = id;
        this.contactName = contactName;
        this.addressLine1 = addressLine1;
    }

    public Address(String contactName, String addressLine1) {
        this.contactName = contactName;
        this.addressLine1 = addressLine1;
    }

    @NotBlank(message = "The contactName field is required.")
    @Size(max = 100)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @NotBlank(message = "The addressLine1 field is required.")
    @Size(max = 450)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public UUID getCityId() {
        return cityId;
    }

    public void setCityId(UUID cityId) {
        this.cityId = cityId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public UUID getDistrictId() {
        return districtId;
    }

    public void setDistrictId(UUID districtId) {
        this.districtId = districtId;
    }

    public List<City> getCities() {
        return Collections.unmodifiableList(cities);
    }

    public List<District> getDistricts() {
        return Collections.unmodifiableList(districts);
    }
}