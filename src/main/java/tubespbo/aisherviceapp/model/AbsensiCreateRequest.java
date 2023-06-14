package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbsensiCreateRequest {
    private Long id_montir;
    private LocalDateTime tanggal;
    private int status;
    private String keterangan;
}
