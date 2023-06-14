package tubespbo.aisherviceapp.entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Services {
    
    @Id
    @Column(name="id_service")
    private int id_service;


    @Column(name="catatan_kerusakan")
    private String Catatankerusakan;

    @Column(name="waktu_mulai")
    private Timestamp Waktumulai;

    @Column(name="estimasi_selesai")
    private Timestamp Estimasiselesai;

    @OneToOne
    @JoinColumn(name="id_montir", referencedColumnName = "id_montir")
    private Montir montir;

    @OneToOne
    @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan")
    private Customer customer;

}
