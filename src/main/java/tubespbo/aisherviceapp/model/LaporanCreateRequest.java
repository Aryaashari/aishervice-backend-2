package tubespbo.aisherviceapp.model;

import java.time.LocalDateTime;

// import javax.print.attribute.standard.DateTimeAtCreation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaporanCreateRequest {
    private String keterangan;
    private LocalDateTime tanggal;
    private String tipe;
    private float total;
}
