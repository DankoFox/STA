package com.bachkhoa.STA.tracker;

import com.bachkhoa.STA.peer.PeerInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackerService {

    // Map to store file pieces and which peers have them
    private Map<String, List<PeerInfo>> filePieceToPeersMap = new HashMap<>();

    // Register a peer and their file pieces
    public void registerPeer(String peerId, List<String> filePieces) {
        for (String piece : filePieces) {
            filePieceToPeersMap.computeIfAbsent(piece, k -> new ArrayList<>()).add(new PeerInfo(peerId));
        }
    }

    // Find peers that have a specific file piece
    public List<PeerInfo> getPeersForFilePiece(String filePiece) {
        return filePieceToPeersMap.getOrDefault(filePiece, List.of());
    }

    // Remove a peer when they disconnect
    public void removePeer(String peerId) {
        filePieceToPeersMap.values().forEach(list -> list.removeIf(peer -> peer.getPeerId().equals(peerId)));
    }
}

