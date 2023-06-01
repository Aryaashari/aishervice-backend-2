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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kendaraan")
public class Transportation {
    @Id
    @Column(name = "no_plat")
    private String noPlat;

    @Column(name = "id_pelanggan")
    private Long idPelanggan;

    @Column(name = "jenis_kendaraan")
    private String jenisKendaraan;

    @Column(name = "nomor_mesin")
    private String nomorMesin;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan")
    private Customer customer;
}
