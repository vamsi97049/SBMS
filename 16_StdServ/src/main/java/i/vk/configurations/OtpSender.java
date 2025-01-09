package i.vk.configurations;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class OtpSender {
    
    public int generateOTP() {
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }
}