package by.bsu.anasem.model;

import java.util.Objects;

public class CarBookingCriteria {
    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpDate;
    private String dropOffDate;
    private String puHour;
    private String puMinute;
    private String doHour;
    private String doMinute;

    public CarBookingCriteria(String pickUpLocation, String dropOffLocation,
                                   String pickUpDate, String dropOffDate, String puHour,
                                   String puMinute, String doHour, String doMinute) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.puHour = puHour;
        this.puMinute = puMinute;
        this.doHour = doHour;
        this.doMinute = doMinute;
    }

    public CarBookingCriteria(String pickUpLocation, String pickUpDate, String dropOffDate, String puHour,
                              String puMinute, String doHour, String doMinute) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.puHour = puHour;
        this.puMinute = puMinute;
        this.doHour = doHour;
        this.doMinute = doMinute;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getPuHour() {
        return puHour;
    }

    public void setPuHour(String puHour) {
        this.puHour = puHour;
    }

    public String getPuMinute() {
        return puMinute;
    }

    public void setPuMinute(String puMinute) {
        this.puMinute = puMinute;
    }

    public String getDoHour() {
        return doHour;
    }

    public void setDoHour(String doHour) {
        this.doHour = doHour;
    }

    public String getDoMinute() {
        return doMinute;
    }

    public void setDoMinute(String doMinute) {
        this.doMinute = doMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBookingCriteria that = (CarBookingCriteria) o;
        return Objects.equals(pickUpLocation, that.pickUpLocation) &&
                Objects.equals(dropOffLocation, that.dropOffLocation) &&
                Objects.equals(pickUpDate, that.pickUpDate) &&
                Objects.equals(dropOffDate, that.dropOffDate) &&
                Objects.equals(puHour, that.puHour) &&
                Objects.equals(puMinute, that.puMinute) &&
                Objects.equals(doHour, that.doHour) &&
                Objects.equals(doMinute, that.doMinute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpLocation, dropOffLocation, pickUpDate, dropOffDate, puHour, puMinute, doHour, doMinute);
    }
}
