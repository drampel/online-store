package az.apple_corporation.auth.dao;

import az.apple_corporation.auth.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "auth_user_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserHistoryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private AuthUserEntity authUser;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String salt;
    private String verifier;
    @Enumerated(STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}