package com.dotalist.dalviik.dota2heroes.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dotalist.dalviik.dota2heroes.R;
import com.dotalist.dalviik.dota2heroes.model.Heroe;

import java.util.ArrayList;


public class ListaHeroesAdapter extends RecyclerView.Adapter<ListaHeroesAdapter.ViewHolder>{

    private ArrayList<Heroe> dataset;
    private Context context;

    public ListaHeroesAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroe,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Heroe h= dataset.get(position);
        holder.heroenombreTextView.setText(h.getLocalized_name());
        Glide.with(context)
                .load("http://devilesk.com/media/images/spellicons/abaddon_borrowed_time.png")

              .into(holder.heroeImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarHeroe(ArrayList<Heroe> listaHeroe) {
        dataset.addAll(listaHeroe);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView heroeImageView;
        private TextView heroenombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            heroeImageView =(ImageView) itemView.findViewById(R.id.heroeImageView);
            heroenombreTextView =(TextView) itemView.findViewById(R.id.heroeTextView);

        }
    }
}
