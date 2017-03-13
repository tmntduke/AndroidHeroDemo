package tmnt.example.androidherodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private TextView top;
    private List<String> mList;
    private int topPosition = 0;
    private boolean isLast;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        mListView = (ListView) findViewById(R.id.list);
        top = (TextView) findViewById(R.id.header);

        Collections.sort(mList, String::compareTo);
        ListSelectAdpter adaAdpter = new ListSelectAdpter(this, mList);
        mListView.setAdapter(adaAdpter);

        init();
    }

    private void init() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (isLast && scrollState == SCROLL_STATE_IDLE) {
                    Log.i(TAG, "onScrollStateChanged: " + topPosition);
                    top.setText(mList.get(topPosition + 1).substring(0, 1));
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(TAG, "onScroll: " + firstVisibleItem);
                topPosition = firstVisibleItem;
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    isLast = true;
                } else {


                    top.setText(mList.get(firstVisibleItem).substring(0, 1));

                    isLast = false;
                }

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 3) {
                    Intent in = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(in);
                }
            }
        });
    }

    private void getData() {
        mList = new ArrayList<>();
        mList.add("tmnt");
        mList.add("tony");
        mList.add("tom");
        mList.add("any");
        mList.add("duke");
        mList.add("joury");
        mList.add("bob");
        mList.add("jommes");
        mList.add("banana");
        mList.add("apple");
        mList.add("chain");
        mList.add("master");
        mList.add("list");
        mList.add("over");
        mList.add("lenovo");
        mList.add("sony");
        mList.add("ASUS");
        mList.add("LG");
        mList.add("san");
    }

}
