/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dilshan
 */
public class NewClass {

    public static void main(String[] args) {
        String table = "customer";

        String sqlStm = "";

        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                sqlStm += "?,";

            } else {
                sqlStm += "?";
            }

        }
        String sqlStm_temp = "INSERT INTO " + table + " VALUES(" + sqlStm + ")";
        System.out.println(sqlStm_temp);

    }

}
