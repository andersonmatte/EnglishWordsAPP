package me.andersonmatte.englishwords.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.entity.OnBoardItem;

public class OnBoardAdapter extends PagerAdapter {

    private Context context;
    ArrayList<OnBoardItem> items = new ArrayList<>();

    public OnBoardAdapter(Context mContext, ArrayList<OnBoardItem> items) {
        this.context = mContext;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.onboard_item, container, false);

        OnBoardItem item = items.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(item.getIdImagem());

        TextView tv_title = (TextView) itemView.findViewById(R.id.tv_header);
        tv_title.setText(item.getTitulo());

        TextView tv_content = (TextView) itemView.findViewById(R.id.tv_desc);
        tv_content.setText(item.getDescricao());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}