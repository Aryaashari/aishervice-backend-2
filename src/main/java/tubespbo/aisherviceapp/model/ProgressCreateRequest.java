package tubespbo.aisherviceapp.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressCreateRequest{
    private Long id_service;
    private String catatan_progress;
    private Timestamp waktu_progress; 
}
