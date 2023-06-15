package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiCreateRequest {
    private String status;
    private Float total;
}