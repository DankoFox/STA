package com.bachkhoa.STA.tracker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TrackerServer {

    private TrackerService trackerService;

    public TrackerServer(TrackerService trackerService) {
        this.trackerService = trackerService;
    }

    public void startTracker(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Tracker started, listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept(); // Wait for a connection
                new Thread(new TrackerHandler(socket, trackerService)).start(); // Handle peer in a new thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
