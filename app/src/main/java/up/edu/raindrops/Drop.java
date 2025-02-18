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
    protected int invisible = Color.argb(0,0,0,0);
    protected int r = gen.nextInt(256);
    protected int g = gen.nextInt(256);
    protected int b = gen.nextInt(256);
    protected int color = Color.rgb(r,g,b);

    //Generate a random color for a Drop, set the paint instance variable to this color



    //Create a drop with random coordinates within the layout border
    public Drop() {
        x = gen.nextInt(1280);
        y = gen.nextInt(680);
        myPaint = new Paint();
        myPaint.setColor(color);
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(x,y,radius,myPaint);
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setInvisible() {
        myPaint.setColor(invisible);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //helper methods to edit colors
    public void setColor(int r, int g, int b){
        int newColor = Color.rgb(r,g,b);
        myPaint.setColor(newColor);
    }
    public int getR(){
        return r;
    }
    public int getG(){
        return g;
    }
    public int getB(){
        return b;
    }
    //Blends the rgb values of two drops, using helper methods defined above
    public void blendColor(Drop a){
        setColor(r+a.getR()/2,g+a.getG()/2,b+a.getB()/2);
    }





}
