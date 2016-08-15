/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_v1;

/**
 *
 * @author root
 */
public class Archive_v1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login login_form = new Login();
        login_form.setDefaultCloseOperation(login_form.DISPOSE_ON_CLOSE);
        login_form.setResizable(false);
        login_form.pack();
        login_form.setLocationRelativeTo(null);
        login_form.setLocation(350, 150);
        login_form.setVisible(true);
    }
    
}
