package org.nic.bug_tracker_system.uploadFiles;

public class StorageException extends RuntimeException {

	 public StorageException(String message) {
	 super(message);
	 }

	 public StorageException(String message, Throwable cause) {
	 super(message, cause);
	 }
	}