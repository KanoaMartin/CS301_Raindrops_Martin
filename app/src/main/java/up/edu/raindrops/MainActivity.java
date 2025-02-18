package up.edu.raindrops;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RainyDay theRainyDay = this.findViewById(R.id.theRain);
        RaindropController myController = new RaindropController(theRainyDay);

        SeekBar xSlider = this.findViewById(R.id.horizontalSlider);
        SeekBar ySlider = this.findViewById(R.id.verticalSlider);
        xSlider.setProgress(myController.getPrimeX());
        ySlider.setProgress(myController.getPrimeY());

        xSlider.setOnSeekBarChangeListener(myController);
        ySlider.setOnSeekBarChangeListener(myController);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}