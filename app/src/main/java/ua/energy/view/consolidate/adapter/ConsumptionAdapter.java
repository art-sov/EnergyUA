package ua.energy.view.consolidate.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import ua.energy.R;
import ua.energy.entity.ConsumptionTable;

public class ConsumptionAdapter extends RecyclerView.Adapter<ConsumptionAdapter.ConsumptionViewHolder> {

    private List<ConsumptionTable> list;

    public ConsumptionAdapter(List<ConsumptionTable> list) {
        this.list = list;
        for (Iterator<ConsumptionTable> iterator = list.iterator(); iterator.hasNext();){
            ConsumptionTable item = iterator.next();
            if (item.getColumn2() == 0 && item.getColumn3() == 0 && item.getColumn3() == 0)
                iterator.remove();
        }
    }

    @NonNull
    @Override
    public ConsumptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_table2, parent, false);
        return new ConsumptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsumptionViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ConsumptionViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTable2cell1;
        private TextView tvTable2cell2;
        private TextView tvTable2cell3;
        private TextView tvTable2cell4;
        private TextView tvTable2cell5;

        public ConsumptionViewHolder(View itemView) {
            super(itemView);
            tvTable2cell1 = itemView.findViewById(R.id.tvTable2Cell1);
            tvTable2cell2 = itemView.findViewById(R.id.tvTable2Cell2);
            tvTable2cell3 = itemView.findViewById(R.id.tvTable2Cell3);
            tvTable2cell4 = itemView.findViewById(R.id.tvTable2Cell4);
            tvTable2cell5 = itemView.findViewById(R.id.tvTable2Cell5);
        }

        public void bind(ConsumptionTable row) {

            switch (row.getColumn1()){
                case 2:
                    tvTable2cell1.setText("Дн");
                    break;
                case 3:
                    tvTable2cell1.setText("Сев");
                    break;
                case 4:
                    tvTable2cell1.setText("Цн");
                    break;
                case 5:
                    tvTable2cell1.setText("ЮЗ");
                    break;
                case 6:
                    tvTable2cell1.setText("Ю");
                    break;
                case 7:
                    tvTable2cell1.setText("Зп");
                    break;
                case 10:
                    tvTable2cell1.setText("Украина");
                    break;
            }
            tvTable2cell2.setText(Integer.toString(row.getColumn2()));
            tvTable2cell3.setText(Integer.toString(row.getColumn3()));
            tvTable2cell4.setText(Integer.toString(row.getColumn4()));
            tvTable2cell5.setText(Integer.toString(row.getColumn5()));
        }
    }
}
