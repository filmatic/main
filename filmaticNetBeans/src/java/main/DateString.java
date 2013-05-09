/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * HAS TO BE FORMATTED LIKE THIS:
 * YEAR - MONTH - DAY
 * @author kris
 * 
 * 0123456789
 * 2013-05-03
 */

public class DateString {
    private String dateString;
    
    public DateString(String dateString) {
        this.dateString = dateString;
    }
    
    /**
     * CHECKS WHO IS BIGEST
     * RETURNS TRUE IF THE ONE BEING CHECKED FROM IS BIGGEST
     */
    public boolean compare(DateString dateString) {
        
        if (this.getYear()>dateString.getYear()) {
            return true;
        }
        else if (this.getYear()<dateString.getYear()){
            return false;
        }
        // THEIR BOTH EQUAL IN YEARS
        else {
            if (this.getMonth()>dateString.getMonth()) {
                return true;
            }
            else if (this.getMonth()<dateString.getMonth()){
                return false;
            }
            // THEIR BOTH EQUAL IN MONTHS
            else {
                /*
                if (this.getDay()>dateString.getDay()) {
                    return true;
                }
                else if (this.getDay()<dateString.getDay()){
                    return false;
                }
                // THEIR EQUAL IN YEAR MONTH DAY
                else {
                    return true;
                }*/
                return true;
            }
        }
    }
    
    public int getDay() {
        return Integer.valueOf(this.dateString.substring(8));
    }
    
    public int getMonth() {
        return Integer.valueOf(this.dateString.substring(5,7));
    }
    
    public int getYear() {
        // SUBSTRING FROM 0 TO 4
        return Integer.valueOf(this.dateString.substring(0, 4));
    }
    
    public String getDateString() {
        return this.dateString;
    }
        
}
