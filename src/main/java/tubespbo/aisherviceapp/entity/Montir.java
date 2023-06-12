package tubespbo.aisherviceapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "montir")
public class Montir {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_montir")
    private Long idMontir;

    @Column(name = "name")
    private String name;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "email")
    private String email;

    @Column(name = "shift")
    private String shift;

}
