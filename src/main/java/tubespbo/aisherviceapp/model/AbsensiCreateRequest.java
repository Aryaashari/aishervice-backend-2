package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbsensiCreateRequest {
    private Long id_montir;
    private Timestamp tanggal;
    private int status;
    private String keterangan;
}
