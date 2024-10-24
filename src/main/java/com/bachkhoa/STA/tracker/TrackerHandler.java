package com.bachkhoa.STA.tracker;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class TrackerHandler implements Runnable {

    private Socket socket;
    private TrackerService trackerService;

    public TrackerHandler(Socket socket, TrackerService trackerService) {
        this.socket = socket;
        this.trackerService = trackerService;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                // Handle incoming messages from the peer (register, request peers, etc.)
                System.out.println("Received: " + message);

                // Basic example: Register peer
                if (message.startsWith("REGISTER")) {
                    // Extract peer info and file pieces
                    String peerId = message.split(" ")[1]; // Example format: REGISTER peerId piece1 piece2...
                    String[] pieces = message.split(" ")[2].split(",");
                    trackerService.registerPeer(peerId, List.of(pieces));

                    out.println("REGISTERED");
                }

                // Example: Request file piece
                if (message.startsWith("REQUEST")) {
                    String filePiece = message.split(" ")[1]; // Example format: REQUEST piece1
                    var peers = trackerService.getPeersForFilePiece(filePiece);
                    out.println("PEERS: " + peers);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

