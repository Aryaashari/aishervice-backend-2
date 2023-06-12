package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MontirCreateRequest {
    private String nama;
    private String noHp;
    private String alamat;
    private String email;
    private String shift;
}
