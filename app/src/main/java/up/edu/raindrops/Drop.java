//@author Kanoa Martin
//This class allows the creation of random raindrops to be drawn on the app
package up.edu.raindrops;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;


public class Drop {
    //Instance variables, notably radius is constant at 30
    protected int x;
    protected int y;
    protected int radius = 30;
    protected Paint myPaint;
    protected Random gen = new Random();

    //Generate a random color for a Drop, set the paint instance variable to this color

    protected void setRandDrop(){
        int color = Color.rgb(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }

    //Create a drop with random coordinates within the layout border
    public Drop() {
        x = gen.nextInt(1280);
        y = gen.nextInt(700);
        setRandDrop();
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(x,y,radius,myPaint);
    }

}
