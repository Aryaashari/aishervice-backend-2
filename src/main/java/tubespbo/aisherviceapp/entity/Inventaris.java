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
    private int id_inventaris;

    @Column(name="suku_cadang")
    private String suku_cadang;
    private int stok;
    private int harga_satuan;
}
