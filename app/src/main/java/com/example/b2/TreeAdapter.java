package com.example.b2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b2.model.Tree;

import java.io.Serializable;
import java.util.List;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.ViewHolder>{

    private Context context;
    private List<Tree> list;
    private Tree tree;
    private LinearLayout linearLayout;


    public TreeAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Tree> stores){
        this.list = stores;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tree tree = list.get(position);

        if(tree == null){
            return;
        }

        //holder.imgStore.setImageResource(tree.getResourceId());
        holder.nameStore.setText(tree.getTenthuonggoi());

        tree.setTenkhoahoc(holder.nameStore.getText().toString());
       // store.setResourceId(Integer.valueOf(String.valueOf(holder.imgStore.getDrawable())));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStoreDetail(tree);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgStore;
        private TextView nameStore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.img);
            nameStore = itemView.findViewById(R.id.tv_title);
            linearLayout = itemView.findViewById(R.id.item_store_layout);
        }
    }
    public void onClickStoreDetail(Tree tree){
        Intent intent = new Intent(context, StoreActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", (Serializable) tree);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
