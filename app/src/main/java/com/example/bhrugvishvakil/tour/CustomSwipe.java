package com.example.bhrugvishvakil.tour;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by BhrugvishVakil on 15/03/18.
 */

public class CustomSwipe extends PagerAdapter {
    private int[] image_resource={R.drawable.image,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    private Context context;
    private LayoutInflater layoutInflater;
    public CustomSwipe(Context context)
    {
 this.context=context;
    }
    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.imageview);
        imageView.setImageResource(image_resource[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
