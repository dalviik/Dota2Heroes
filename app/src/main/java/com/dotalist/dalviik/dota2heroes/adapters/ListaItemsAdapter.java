package com.dotalist.dalviik.dota2heroes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dotalist.dalviik.dota2heroes.R;
import com.dotalist.dalviik.dota2heroes.model.Item;

import java.util.ArrayList;


public class ListaItemsAdapter extends RecyclerView.Adapter<ListaItemsAdapter.ViewHolder> {

    private ArrayList<Item> dataset;
    private Context context;

    public ListaItemsAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item i= dataset.get(position);
        holder.itemnombreTextView.setText(i.getName());
        Glide.with(context)
                .load("http://wiki.teamliquid.net/commons/images/a/a1/Octarine_core_hi_res.png")

                .into(holder.itemImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public void adicionarItem(ArrayList<Item> listaItem) {
        dataset.addAll(listaItem);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemImageView;
        private TextView itemnombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageView =(ImageView) itemView.findViewById(R.id.itemImageView);
            itemnombreTextView =(TextView) itemView.findViewById(R.id.itemTextView);

        }
    }
}
