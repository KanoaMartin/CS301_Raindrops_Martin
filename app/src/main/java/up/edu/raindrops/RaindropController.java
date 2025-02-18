//@author Kanoa Martin
package up.edu.raindrops;

import android.widget.SeekBar;

public class RaindropController implements SeekBar.OnSeekBarChangeListener {
    private RainyDay myRainyDay;
    private int primeX;
    private int primeY;
    public RaindropController(RainyDay thisRainyDay){
        myRainyDay = thisRainyDay;
        primeX = myRainyDay.getDropX();
        primeY = myRainyDay.getDropY();
    }
    public int getPrimeX(){
        return primeX;
    }
    public int getPrimeY(){
        return primeY;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId() == R.id.horizontalSlider){
            myRainyDay.setPrimeX(progress);
            myRainyDay.invalidate();
        }
        if(seekBar.getId() == R.id.verticalSlider){
            myRainyDay.setPrimeY(progress);
            myRainyDay.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
