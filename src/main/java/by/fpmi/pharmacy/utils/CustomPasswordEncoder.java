package by.fpmi.pharmacy.utils;


import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class CustomPasswordEncoder extends MessageDigestPasswordEncoder {
    public CustomPasswordEncoder(String algorithm) {
        super(algorithm);
    }
}
