package com.bachkhoa.STA.peer;

public class PeerInfo {
    private String peerId;
    private String ipAddress;
    private int port;

    // Constructor, getters, setters
    public PeerInfo(String peerId) {
        this.peerId = peerId;
        // Dummy values for now, you can add IP and port handling later
        this.ipAddress = "127.0.0.1";
        this.port = 8080;
    }

    public String getPeerId() {
        return peerId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }
}
