package tubespbo.aisherviceapp.entity;

<<<<<<< HEAD
import java.sql.Timestamp;
=======


>>>>>>> 274c269988e686f81bf9de119160ad832a32c263

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
<<<<<<< HEAD

=======
import java.time.LocalDateTime;
>>>>>>> 274c269988e686f81bf9de119160ad832a32c263

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "absensi")
public class Absensi {
<<<<<<< HEAD
    
    @Id
    @Column(name = "id_absensi")
    private Long idAbsensi;

    private Timestamp tanggal;

    private String status;
    private String keterangan;

}
=======
    @Id
    @Column(name="id_absensi")
    private Long idAbsensi;

    @Column(name="tanggal")
    private LocalDateTime tanggal;

    @Column(name="status")
    private int status;

    @Column(name="keterangan")
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "id_montir", referencedColumnName = "id_montir")
    private Montir montir ;
}
>>>>>>> 274c269988e686f81bf9de119160ad832a32c263
