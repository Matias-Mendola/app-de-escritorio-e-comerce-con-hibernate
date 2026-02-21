
package main;

import org.mindrot.jbcrypt.BCrypt;

public class PaswordHasher {
    public static String hash(String passwordPlano){
     return BCrypt.hashpw(passwordPlano, BCrypt.gensalt());
    
    }
    public static boolean verificar(String passwordPlano, String hashAlmacenado) {
        try {
            return BCrypt.checkpw(passwordPlano, hashAlmacenado);
        } catch (Exception e) {
            return false;
        }
    }
}
