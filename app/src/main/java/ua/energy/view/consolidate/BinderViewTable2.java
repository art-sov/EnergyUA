package ua.energy.view.consolidate;

import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import ua.energy.R;

public class BinderViewTable2 implements SimpleAdapter.ViewBinder{

    private int colorHeaderBack;
    private int colorHeaderText;
    private int colorCellBack;
    private int colorCellText;

    public BinderViewTable2(int colorHeaderBack, int colorHeaderText,
                            int colorCellBack, int colorCellText) {
        this.colorHeaderBack = colorHeaderBack;
        this.colorHeaderText = colorHeaderText;
        this.colorCellBack = colorCellBack;
        this.colorCellText = colorCellText;
    }

    @Override
    public boolean setViewValue(View view, Object data, String text) {

        TextView textView = (TextView)view;
        switch (view.getId()) {
            case R.id.tvTable2Cell1:
                if (text.equals("Энергосистема")) {
                    textView.setBackgroundColor(colorHeaderBack);
                    textView.setTextColor(colorHeaderText);
                    textView.setText(text);
                }
                else {
                    textView.setBackgroundColor(colorCellBack);
                    textView.setTextColor(colorCellText);
                    textView.setText(text);
                }
                return true;
            case R.id.tvTable2Cell2:
                if (text.equals("")) {
                    textView.setBackgroundColor(colorHeaderBack);
                    textView.setTextColor(colorHeaderText);
                    textView.setText(text);
                }
                else {
                    textView.setBackgroundColor(colorCellBack);
                    textView.setTextColor(colorCellText);
                    textView.setText(text);
                }
                return true;
            case R.id.tvTable2Cell3:
                if (text.equals("Сумма облэнерго")) {
                    textView.setBackgroundColor(colorHeaderBack);
                    textView.setTextColor(colorHeaderText);
                    textView.setText(text);
                }
                else {
                    textView.setBackgroundColor(colorCellBack);
                    textView.setTextColor(colorCellText);
                    textView.setText(text);
                }
                return true;

            case R.id.tvTable2Cell4:
                if (text.equals("")) {
                    textView.setBackgroundColor(colorHeaderBack);
                    textView.setTextColor(colorHeaderText);
                    textView.setText(text);
                }
                else {
                    textView.setBackgroundColor(colorCellBack);
                    textView.setTextColor(colorCellText);
                    textView.setText(text);
                }
                return true;
            case R.id.tvTable2Cell5:
                if (text.equals("")) {
                    textView.setBackgroundColor(colorHeaderBack);
                    textView.setTextColor(colorHeaderText);
                    textView.setText(text);
                }
                else {
                    textView.setBackgroundColor(colorCellBack);
                    textView.setTextColor(colorCellText);
                    textView.setText(text);
                }
                return true;
        }
        return false;
    }
}
