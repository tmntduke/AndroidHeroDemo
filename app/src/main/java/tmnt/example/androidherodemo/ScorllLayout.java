package tmnt.example.androidherodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by tmnt on 2017/3/10.
 */
public class ScorllLayout extends LinearLayout {

    private Scroller mScroller;

    public ScorllLayout(Context context) {
        super(context);
        init(context);
    }

    public ScorllLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScorllLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    public void setStartScorll(int x, int y) {
        setStartScorll((int) this.getX(), (int) this.getY(), (int) (x + getX()), (int) (y + getY()), 2500);

    }

    public void setStartScorll(int currX, int currY, int x, int y, int duration) {
        mScroller.startScroll(currX, currY, x, y, duration);
        invalidate();
    }

    @Override
    public void computeScroll() {

        if (mScroller.computeScrollOffset()) {
            this.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
