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
@Table(name = "montir")
public class Montir {
    @Id
    @Column(name="id_montir")
    private Long idMontir;
    private String nama;

    @Column(name="no_hp")
    private String noHp;
    private String alamat;
    private String email;
    private String shift;
}
