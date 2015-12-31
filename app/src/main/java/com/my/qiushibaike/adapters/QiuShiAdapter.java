package com.my.qiushibaike.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.my.qiushibaike.R;
import com.my.qiushibaike.entities.QiuShiItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class QiuShiAdapter extends BaseAdapter {
    private Context context;
    private List<QiuShiItem.ItemsEntity> list;

    public QiuShiAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_qiushi, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        QiuShiItem.ItemsEntity item = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if (item.getUser() != null) {
            holder.name.setText(item.getUser().getLogin());
            holder.icon.setImageURI(Uri.parse(item.getIconUrl()));
        } else {
            holder.name.setText("匿名用户");
            holder.icon.setImageURI(Uri.parse("res:///" + R.mipmap.default_anonymous_users_avatar));
        }
        holder.content.setText(item.getContent());
        if (item.getImage() == null) {
            holder.image.setVisibility(View.GONE);
        } else {
            holder.image.setVisibility(View.VISIBLE);
            holder.image.setImageURI(Uri.parse(item.getImageUrl()));
        }
        return convertView;
    }

    public void addAll(Collection<? extends QiuShiItem.ItemsEntity> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        private SimpleDraweeView icon;
        private ImageView image;
        private TextView content;
        private TextView name;

        public ViewHolder(View itemView) {
            icon = ((SimpleDraweeView) itemView.findViewById(R.id.user_icon));
            image = ((ImageView) itemView.findViewById(R.id.image));
            content = ((TextView) itemView.findViewById(R.id.content));
            name = ((TextView) itemView.findViewById(R.id.user_name));
        }
    }
}
