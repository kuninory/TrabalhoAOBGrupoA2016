package sortingapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class TimerCounter {

    private long startTime = 0;
    private long endTime = 0;

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        endTime = System.currentTimeMillis();
    }

    public long getDiffMillis() {
        return (endTime - startTime);
    }

    public long getDiffSeconds() {
        return (endTime - startTime) / 1000;
    }

    public String getStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        Date resultdate = new Date(startTime);
        return sdf.format(resultdate);
    }

    public String getEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        Date resultdate = new Date(endTime);
        return sdf.format(resultdate);
    }

    public String getMediumTime(int numberOfElem) {
        long milliSecPerElem = (this.getDiffMillis()) / numberOfElem;
        String result = milliSecPerElem + "ms/Elem";
        return result;
    }

}
