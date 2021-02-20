package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyItem> {

    private Context context;
    private ArrayList<Image> arrayList;

    DataAdapter(ArrayList<Image> a, Context c) {
        this.arrayList = a;
        this.context = c;
    }

    @NonNull
    @Override
    public MyItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myitem_row,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Text",Toast.LENGTH_LONG).show();
                Snackbar.make(parent.getRootView().findViewById(R.id.root),"T123",Snackbar.LENGTH_LONG).show();
                Log.d("RRRR","Test");
            }
        });
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
