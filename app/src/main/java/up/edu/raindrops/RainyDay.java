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

    //Create a random number generator, for initializing a random amount of raindrops, and create an array of raindrops with a random length from 6-12,
    //the first drop in the array is moveable

    private Random gen = new Random();
    private Drop[] rainDrops = new Drop[gen.nextInt(7)+6];
    private Drop primeDrop = new Drop();



    //Constructor that initializes all the values in the array as random Drops, the first drop in the array is moveable
    public RainyDay(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        rainDrops[0] = primeDrop;

        for(int j = 1;j<rainDrops.length;j++){
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
    public int getDropX(){
        return primeDrop.x;
    }
    public int getDropY(){
        return primeDrop.y;
    }
    public void setPrimeX(int x){
        primeDrop.setX(x);
    }
    public void setPrimeY(int y){
        primeDrop.setY(y);
    }
    //method to check if a drop is overlapping with another
    public void checkTouches(){
        for(int k = 1;k< rainDrops.length;k++){
            if(Math.abs(primeDrop.getX()-rainDrops[k].getX()) < 60 && Math.abs(primeDrop.getY()-rainDrops[k].getY()) < 60){
                rainDrops[k].setInvisible();
                primeDrop.blendColor(rainDrops[k]);
            }
        }
    }

    
}
