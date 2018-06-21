package sih.com.sih.Modals;

/**
 * Created by kapil on 21/6/18.
 */

public class BeaconModel {

    int rssi;
    String name;
    String macAddress;

    public BeaconModel(int rssi, String name, String macAddress) {
        this.rssi = rssi;
        this.name = name;
        this.macAddress = macAddress;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}




/*

*/