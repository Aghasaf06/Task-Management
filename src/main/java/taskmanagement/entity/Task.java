package taskmanagement.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import taskmanagement.model.TaskPriority;
import taskmanagement.model.TaskStatus;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @Enumerated(EnumType.STRING)
    TaskPriority priority;

    LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
