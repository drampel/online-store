package az.apple_corporation.user.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import az.apple_corporation.user.model.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static az.apple_corporation.user.model.Status.ACTIVE;

@Entity
@Table(name = "auth_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "status != 'DELETED'")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String salt;
    private String verifier;
    @Enumerated(STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    void init() {
        this.status = ACTIVE;
    }
}