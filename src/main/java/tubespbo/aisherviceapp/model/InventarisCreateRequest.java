package tubespbo.aisherviceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarisCreateRequest{
    private String suku_cadang;
    private int stok;
    private int harga_satuan; 
}
