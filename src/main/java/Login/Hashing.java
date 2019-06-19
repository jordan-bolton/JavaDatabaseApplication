/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jorda
 */
public class Hashing {
    
    private final int logRounds;
    
    public Hashing(int logRounds) {
        this.logRounds = logRounds;
    }
    
    
    public String hashPassword(String unhashedPass) {
        return BCrypt.hashpw(unhashedPass, BCrypt.gensalt(logRounds));
    }
    
    public boolean verifyPassword(String input, String hash) {
        return BCrypt.checkpw(input, hash);
    }
    
}
