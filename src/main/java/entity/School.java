package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "SCHOOL_DB"
)
public class School {
    @Id
    @Type(type = "uuid-char")
    private UUID schoolId = UUID.randomUUID();
    @Column(
            nullable = false,
            unique = true
    )
    private String schoolName;
    @Column(
            nullable = false,
            unique = true
    )
    private String schoolEmail;
    private String address;
    @Column(
            unique = true
    )
    private Integer phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateJoined;

    @PrePersist
    private void onCreate() {
        dateJoined = new Date();
    }


}
