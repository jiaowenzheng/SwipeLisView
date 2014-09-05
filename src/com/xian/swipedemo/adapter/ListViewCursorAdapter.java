package com.xian.swipedemo.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xian.swipe.SwipeCusorAdapter;
import com.xian.swipe.SwipeLayout;
import com.xian.swipedemo.R;


public class ListViewCursorAdapter extends SwipeCusorAdapter {



    private final Context mContext;

    public ListViewCursorAdapter(Context context, Cursor c) {
        super(context, c);
        this.mContext = context;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                Log.i("tt", "onClose ..........");
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                Log.i("tt", "onUpdate ..........");
            }

            @Override
            public void onOpen(SwipeLayout layout) {
                // YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
                Log.i("tt", "onOpen ..........");
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                Log.i("tt", "onHandRelease ..........");
            }
        });
        return v;
    }

    @Override
    public void fillValues(final Cursor cursor, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText((cursor.getString(1)));

        convertView.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Star position " + getCursor().getPosition(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        convertView.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Trash Bin position " + getCursor().getPosition(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        convertView.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Magnifier position " + getCursor().getPosition(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
