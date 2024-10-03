package org.nic.bug_tracker_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.nic.bug_tracker_system.enums.*;

import java.time.LocalDateTime;

@Data
@Entity
public class TicketDirectory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ticketNo;
    
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    
    @Enumerated(EnumType.STRING)
    private SeverityEnum severity;
    
    @Enumerated(EnumType.STRING)
    private ReproducibilityEnum reproducibility;
    
    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    private String assignedTo;
    private String assignedBy;
    private String ticketDescription;
    private String ticketSubject;
    private String attachments;  // File attachment path
    
    private LocalDateTime assignedTime;
    private LocalDateTime completionDatetime;
    private Long estimatedTime;
    private Boolean activeFlag = true;

    @PrePersist
    protected void onCreate() {
        this.ticketNo = "TASK" + id;
    }
}
