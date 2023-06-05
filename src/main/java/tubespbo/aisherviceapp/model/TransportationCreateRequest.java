package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportationCreateRequest {
    private String noPlat;
    private Long idPelanggan;
    private String jenisKendaraan;
    private String nomorMesin;
}
