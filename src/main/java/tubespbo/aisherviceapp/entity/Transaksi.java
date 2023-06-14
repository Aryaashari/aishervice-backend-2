package tubespbo.aisherviceapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "transaksi")
public class Transaksi {
    
    @Id
    @Column (name="id_transaksi")
    private Long id_transaksi;

    @Column(name="Status")
    private String status;
    private Float total;

    @OneToOne
    @JoinColumn(name="id_service", referencedColumnName = "id_service")
    private Services services;

}
