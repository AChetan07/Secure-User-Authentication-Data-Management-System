package HashGen;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashGen {
    public static void main(String[] args) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();   // cost 10 by default
        String hash = enc.encode("password");
        System.out.println(hash);
        System.out.println(enc.matches("password", hash));        // true
    }
}