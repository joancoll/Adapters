package cat.dam.andy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] images;
    String[] names;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, int[] images, String[] names) {
        this.context = applicationContext;
        this.images = images;
        this.names = names;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.custom_spinner_item,null);
            ImageView image = view.findViewById(R.id.iv_fruit_image);
            TextView name =  view.findViewById(R.id.tv_fruit_name);
            image.setImageResource(images[i]);
            name.setText(names[i]);
        }
        return view;
    }
}