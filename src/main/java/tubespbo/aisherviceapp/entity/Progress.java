package tubespbo.aisherviceapp.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Column(name = "id_proses") 
    private int id_proses;

    @Column(name="id_service")
    private Long id_service;

    @Column(name="catatan_proses")
    private String catatan_proses;

    @Column(name = "waktu_progress")
    private Timestamp waktu_progress;
}
