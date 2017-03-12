package tmnt.example.androidherodemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by tmnt on 2017/3/10.
 */
public class SecondActivity extends AppCompatActivity {

    private ScorllLayout mScorllLayout;

    private Button btn;
    private ImageView img;
    private ImageView img1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_lay);
        mScorllLayout = (ScorllLayout) findViewById(R.id.lay);
        btn = (Button) findViewById(R.id.btn);
        img= (ImageView) findViewById(R.id.img);
        img1= (ImageView) findViewById(R.id.img1);

        btn.setOnClickListener(v->{
            mScorllLayout.setStartScorll(-100,-100);
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setPivotX(0.5F);
                img.setPivotY(0.5F);
                Drawable drawable=img.getDrawable();
                ((Animatable)drawable).start();
            }
        });

        Animator animator= AnimatorInflater.loadAnimator(this,R.animator.svg_animtor);
        animator.setTarget(img1);
        animator.start();

    }
}
