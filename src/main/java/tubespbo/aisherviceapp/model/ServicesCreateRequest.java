package tubespbo.aisherviceapp.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesCreateRequest {
    private String catatankeruksan;
    private Timestamp waktumulai;
    private Timestamp estimasiwaktu;
}
