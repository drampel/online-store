package az.apple_corporation.auth.dao;

import az.apple_corporation.auth.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import java.time.LocalDateTime;

import static az.apple_corporation.auth.model.Status.ACTIVE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "auth_user")
@EntityListeners(AuthUserListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    AuthUserHistoryEntity toAuthUserHistoryEntity() {
        return AuthUserHistoryEntity.builder()
                .authUser(this)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .mobileNumber(this.mobileNumber)
                .email(this.email)
                .salt(this.salt)
                .verifier(this.verifier)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    @PrePersist
    void init() {
        this.status = ACTIVE;
    }
}