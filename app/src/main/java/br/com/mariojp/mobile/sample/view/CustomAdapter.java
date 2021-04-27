package br.com.mariojp.mobile.sample.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.mariojp.mobile.sample.R;
import br.com.mariojp.mobile.sample.model.Contato;

public class CustomAdapter extends ListAdapter<Contato,CustomAdapter.CustomViewHolder> {


    public CustomAdapter(@NonNull DiffUtil.ItemCallback<Contato> diff) {
        super(diff);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.getTextView().setText(getItem(position).getNome());
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.main_item_id);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    static class ContatoDiff extends DiffUtil.ItemCallback<Contato> {

        @Override
        public boolean areItemsTheSame(@NonNull Contato oldItem, @NonNull Contato newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Contato oldItem, @NonNull Contato newItem) {
            return (oldItem.getUid() == newItem.getUid()) && oldItem.getNome().equals(newItem.getNome());
        }
    }

}
