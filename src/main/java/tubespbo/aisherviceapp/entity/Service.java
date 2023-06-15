package tubespbo.aisherviceapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long idService;

    @Column(name = "catatan_kerusakan")
    private String catatanKerusakan;

    @Column(name = "waktu_mulai")
    private LocalDateTime waktuMulai;

    @Column(name = "estimasi_selesai")
    private LocalDateTime estimasiSelesai;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_montir", referencedColumnName = "id_montir")
    private Montir montir;

    @OneToOne(mappedBy = "service")
    private Progress progress;

    @OneToOne(mappedBy = "service")
    private Transaksi transaksi;

}
