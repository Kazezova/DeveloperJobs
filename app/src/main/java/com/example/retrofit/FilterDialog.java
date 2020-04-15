package com.example.retrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import android.app.DialogFragment;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class FilterDialog extends DialogFragment {
    private EditText description;
    private EditText location;
    private Button filter;
    private CheckBox full_time;

    public static FilterDialog newInstance() {
        return new FilterDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_dialog, null);
        description = view.findViewById(R.id.filter_description);
        location = view.findViewById(R.id.filter_location);
        full_time = view.findViewById(R.id.filter_full_time);
        filter = view.findViewById(R.id.filter_button);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = description.getText().toString();
                String loc = location.getText().toString();
                boolean type = full_time.isChecked();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, MainFragment.newInstance(desc, loc, type))
                        .commit();
                dismiss();
            }
        });
        return view;
    }

}