package tubespbo.aisherviceapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "customer")
public class Customer {
    @Id
    private Long idPelanggan;
    private String nama;

    @Column(name="no_hp")
    private String noHp;
    private String alamat;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Transportation> transportations;
}
