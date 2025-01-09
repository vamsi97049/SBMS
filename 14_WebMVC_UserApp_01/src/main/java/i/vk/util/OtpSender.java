package i.vk.util;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OtpSender {
    
    public int generateOTP() {
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }
}
