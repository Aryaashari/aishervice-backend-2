package tubespbo.aisherviceapp.entity;

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
@Table(name ="inventaris")

public class Inventaris {
    @Id
    @Column(name = "id_inventaris") 
    private int id_inventaris;

    @Column(name="suku_cadang")
    private String suku_cadang;

    @Column(name="stok")
    private int stok;
    @Column(name = "harga_satuan")
    private int harga_satuan;
}
