package ua.energy.view.consolidate.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.energy.R;
import ua.energy.entity.ConsolidateTable;

public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.BalanceViewHolder> {

    private List<ConsolidateTable> list;

    public BalanceAdapter(List<ConsolidateTable> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BalanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_table1, parent, false);
        return new BalanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BalanceViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BalanceViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTable1Cell1;
        private TextView tvTable1Cell2;
        private TextView tvTable1Cell3;
        private TextView tvTable1Cell4;

        public BalanceViewHolder(View itemView) {
            super(itemView);
            tvTable1Cell1 = itemView.findViewById(R.id.tvTable1Cell1);
            tvTable1Cell2 = itemView.findViewById(R.id.tvTable1Cell2);
            tvTable1Cell3 = itemView.findViewById(R.id.tvTable1Cell3);
            tvTable1Cell4 = itemView.findViewById(R.id.tvTable1Cell4);
        }

        void bind(ConsolidateTable row) {
         tvTable1Cell1.setText(row.getColumn2());
         if (row.getColumn2().equals("Частота,Гц")){
             tvTable1Cell2.setText(String.format("%.2f", row.getColumn3()));
             tvTable1Cell3.setText(String.format("%.2f", row.getColumn4()));
             tvTable1Cell4.setText(String.format("%.3f", row.getColumn5()));
         }
         else {
             tvTable1Cell2.setText(String.format("%.0f", row.getColumn3()));
             tvTable1Cell3.setText(String.format("%.0f", row.getColumn4()));
             tvTable1Cell4.setText(String.format("%.3f", row.getColumn5()));
         }
        }
    }
}
