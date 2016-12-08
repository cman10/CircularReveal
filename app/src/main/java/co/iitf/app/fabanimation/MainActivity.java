package co.iitf.app.fabanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button hide_btn,show_btn;
    LinearLayout data_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hide_btn= (Button) findViewById(R.id.hideBtn);
        show_btn= (Button) findViewById(R.id.bring_back);
        data_show= (LinearLayout) findViewById(R.id.show_data);

        hide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// get the center for the clipping circle
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

                    int cx = data_show.getWidth() / 2;
                    int cy = data_show.getHeight() / 2;

// get the initial radius for the clipping circle
                    float initialRadius = (float) Math.hypot(cx, cy);

// create the animation (the final radius is zero)
                    Animator anim =
                            null;
                    anim = ViewAnimationUtils.createCircularReveal(data_show, cx, cy, initialRadius, 0);


// make the view invisible when the animation is done
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            data_show.setVisibility(View.INVISIBLE);
                        }
                    });

                    anim.start();
                }
                else {
                    data_show.setVisibility(view.INVISIBLE);
                }




            }
        });



        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // previously invisible view
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

// get the center for the clipping circle
                    int cx = data_show.getWidth() / 2;
                    int cy = data_show.getHeight() / 2;

// get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
                    Animator anim =
                            null;
                    anim = ViewAnimationUtils.createCircularReveal(data_show, cx, cy, 0, finalRadius);


// make the view visible and start the animation
                    data_show.setVisibility(View.VISIBLE);
                    anim.start();

                }
                else {

                    data_show.setVisibility(view.VISIBLE);
                }



            }
        });
    }
}
