package com.example.myapplication3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Activity a;
    List<Product> data;

    public ProductAdapter(Activity a, List<Product> data) {
        this.a = a;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = a.getLayoutInflater().inflate(R.layout.itemproduct, null);
        TextView name = view.findViewById(R.id.nameProduct);
        TextView cost = view.findViewById(R.id.costProduct);
        TextView quantity = view.findViewById(R.id.quantityProduct);
        ImageView image = view.findViewById(R.id.imageProduct);
        Product prod = data.get(i);
        name.setText(prod.getName());
        cost.setText(String.valueOf(prod.getCost()));
        quantity.setText(String.valueOf(prod.getQuantity()));
        Picasso.get().load(prod.getThumbnai()).into(image);

        return view;
    }
}
