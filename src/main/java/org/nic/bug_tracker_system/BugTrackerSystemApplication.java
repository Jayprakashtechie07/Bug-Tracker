package org.nic.bug_tracker_system;

import org.nic.bug_tracker_system.uploadFiles.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BugTrackerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerSystemApplication.class, args);
		System.err.println("Application started");
	}

}
