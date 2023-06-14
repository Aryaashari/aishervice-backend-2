package tubespbo.aisherviceapp.entity;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="progress")

public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proses") 
    private Long id_proses;

    @Column(name="catatan_proses")
    private String catatan_proses;

    @Column(name = "waktu_progress")
    private LocalDateTime waktu_progress;

    @OneToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    private Service service;


}
