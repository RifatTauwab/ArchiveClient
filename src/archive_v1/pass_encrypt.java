/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_v1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DeeptoTV
 */
public class pass_encrypt {
    
    public String encrypt(String normal_password)
    {
        
        String encrypted_password = null;
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(normal_password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder stringbuilder = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                stringbuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encrypted_password = stringbuilder.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return encrypted_password;
    }
}
