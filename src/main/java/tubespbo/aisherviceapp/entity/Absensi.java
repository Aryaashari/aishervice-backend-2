package tubespbo.aisherviceapp.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "absensi")
public class Absensi {
    
    @Id
    @Column(name = "id_absensi")
    private Long idAbsensi;

    private Timestamp tanggal;

    private String status;
    private String keterangan;

}
