package org.kdalib.trip_planner.security;

import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log
public class EncodeTest {
    @Test
    public void testEncode() {
        PasswordEncoder enc = new BCryptPasswordEncoder();
        log.info(enc.encode("secret"));
    }
}
