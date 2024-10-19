package com.example.actcardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> { // Corregido aquí
        private List<ListadoDeElementos> mData;
        private LayoutInflater mInflater;
        private Context context;

    public ListAdapter(List<ListadoDeElementos> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listado, parent, false); // Asegúrate de que el layout sea correcto
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListadoDeElementos> items) {
        mData = items;
        notifyDataSetChanged(); // Notificar cambios para actualizar la vista
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombre, ciudad, descripcion;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.IconImageView); // Asegúrate de que el ID sea correcto
            nombre = itemView.findViewById(R.id.SantoTomas); // Asegúrate de que el ID sea correcto
            ciudad = itemView.findViewById(R.id.LaSerena); // Asegúrate de que el ID sea correcto
            descripcion = itemView.findViewById(R.id.statusTextView); // Asegúrate de que el ID sea correcto
        }

        void bindData(ListadoDeElementos item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombre());
            ciudad.setText(item.getCiudad());
            descripcion.setText(item.getDescripcion());
        }
    }
}