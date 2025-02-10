//@author Kanoa Martin
//This class extends surfaceview, and allows raindrops to be drawn on the app layout

package up.edu.raindrops;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.Random;

import java.util.Random;

public class RainyDay extends SurfaceView {

    //Create a random number generator, for initializing a random amount of raindrops, and cfeate an array of raindrops with a random length from 6-12
    private Random gen = new Random();
    private Drop[] rainDrops = new Drop[gen.nextInt(7)+6];


    //Constructor that initializes all the values in the array as random Drops
    public RainyDay(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        for(int j = 0;j<rainDrops.length;j++){
            rainDrops[j] = new Drop();
        }
        
    }
    //Overridden onDraw method, that draws all the drops in the array
    @Override
    public void onDraw(Canvas paper){

        for(int i = 0;i<rainDrops.length;i++){
            rainDrops[i].draw(paper);
        }
    }
    
}
