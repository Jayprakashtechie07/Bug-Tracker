package org.nic.bug_tracker_system.uploadFiles;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

	 private String location;

	 public String getLocation() {
	 return location;
	 }

	 public void setLocation(String location) {
	 this.location = location;
	 }
}
