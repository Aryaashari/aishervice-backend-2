package tubespbo.aisherviceapp.entity;

import javax.print.attribute.standard.DateTimeAtCreation;

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
@Table(name ="report")

public class Laporan {
    @Id
    @Column(name = "id_laporan")
    private int idLaporan;

    @Column(name="keterangan")
    private String keterangan;

    @Column(name="tanggal")
    private DateTimeAtCreation tanggal;

    @Column(name = "tipe")
    private String tipe;

    @Column(name = "total")
    private float total;
}