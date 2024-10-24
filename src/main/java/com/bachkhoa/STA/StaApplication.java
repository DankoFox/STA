package com.bachkhoa.STA;

import com.bachkhoa.STA.tracker.TrackerServer;
import com.bachkhoa.STA.tracker.TrackerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaApplication {

	public static void main(String[] args) {
		TrackerService trackerService = new TrackerService();
		TrackerServer trackerServer = new TrackerServer(trackerService);

		// Start the tracker on port 8080
		trackerServer.startTracker(8080);
	}
}
