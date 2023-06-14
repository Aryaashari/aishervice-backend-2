package tubespbo.aisherviceapp.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ServiceCreateRequest {
    private Long idPelanggan;
    private Long idMontir;
    private float totalBiaya;
    private String catatanKerusakan;
    private LocalDateTime waktuMulai;
    private LocalDateTime estimasiSelesai;
}
