package tubespbo.aisherviceapp.helper;

import java.util.UUID;

public class RandomId {
    
    public static Long getRandomId() {
        UUID uuId = UUID.randomUUID();
        return uuId.getMostSignificantBits() ^ uuId.getLeastSignificantBits();
    }

}
