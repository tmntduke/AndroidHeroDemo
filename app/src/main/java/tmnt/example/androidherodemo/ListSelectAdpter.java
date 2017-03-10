package tmnt.example.androidherodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tmnt on 2017/3/10.
 */
public class ListSelectAdpter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public ListSelectAdpter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lay, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.header = (TextView) view.findViewById(R.id.header);
            viewHolder.select = (TextView) view.findViewById(R.id.select);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        String label = (String) getItem(position);
        if (position == 0 || !((String) getItem(position - 1)).substring(0, 1)
                .equalsIgnoreCase(label.substring(0, 1))) {
            viewHolder.header.setVisibility(View.VISIBLE);
            viewHolder.header.setText(label.substring(0, 1));
        } else {
            viewHolder.header.setVisibility(View.GONE);
        }

        viewHolder.select.setText(mList.get(position));
        return view;
    }

    static class ViewHolder {
        TextView header;
        TextView select;
    }
}
