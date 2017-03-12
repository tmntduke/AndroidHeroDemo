package tmnt.example.androidherodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by tmnt on 2017/3/10.
 */
public class SecondActivity extends AppCompatActivity {

    private ScorllLayout mScorllLayout;

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_lay);
        mScorllLayout = (ScorllLayout) findViewById(R.id.lay);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(v->{
            mScorllLayout.setStartScorll(-100,-100);
        });

    }
}
