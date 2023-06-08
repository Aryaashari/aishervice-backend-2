package tubespbo.aisherviceapp.model;

import javax.print.attribute.standard.DateTimeAtCreation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaporanCreateRequest {
    private String keterangan;
    private DateTimeAtCreation tanggal;
    private String tipe;
    private float total;
}
