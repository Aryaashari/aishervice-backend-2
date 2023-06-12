package tubespbo.aisherviceapp.entity;




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
import java.security.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "absensi")
public class Absensi {
    @Id
    @Column(name="id_absensi")
    private Long idAbsensi;

    @Column(name="tanggal")
    private Timestamp tanggal;

    @Column(name="status")
    private int status;

    @Column(name="keterangan")
    private String keterangan;

    @ManyToOne
    @JoinColumn(name = "id_montir", referencedColumnName = "id_montir")
    private Montir montir ;
}