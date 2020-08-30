package _4a_com.ds.misc_x;

/**
 * Find small angle between hour and minute hand in analog clock
 */
public class X_AngleBetweenHourAndMinuteHand {

    public double angle(int hour, int min){
        double hourAngle = (hour%12)*360/12 + ((double)min/60)*(360/12);
        double minAngle = min*360/60;
        
        double angleDiff = Math.abs(hourAngle - minAngle);
        return angleDiff < 360 - angleDiff ? angleDiff : 360 - angleDiff;
    }
    
    public static void main(String args[]){
        X_AngleBetweenHourAndMinuteHand abm = new X_AngleBetweenHourAndMinuteHand();
        System.out.println(abm.angle(10, 15));
    }
}
