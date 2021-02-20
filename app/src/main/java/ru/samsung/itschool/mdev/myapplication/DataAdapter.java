package ru.samsung.itschool.mdev.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyItem> {

    private ArrayList<Image> arrayList;

    DataAdapter(ArrayList<Image> a) {
        this.arrayList = a;
    }

    @NonNull
    @Override
    public MyItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myitem_row,parent,false);
        return new MyItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItem holder, int position) {
        // берем текст из нашего списка - передаем его через конструктор адаптера
        holder.textView.setText(arrayList.get(position).getName());
        // загрузка изображения
        Picasso.get().load(arrayList.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyItem extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyItem(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
