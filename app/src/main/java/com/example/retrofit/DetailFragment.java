package com.example.retrofit;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    ImageView companyLogo;
    TextView company;
    TextView createdAt;
    TextView title;
    TextView location;
    TextView type;
    TextView description;
    TextView howToApply;
    public static DetailFragment newInstance(Job job){
            DetailFragment fragment=new DetailFragment();
            //с помощью Bundle мы передаем данные в фрагмент
            Bundle bundle = new Bundle();
            bundle.putString("companyLogo", job.getCompanyLogo());
            bundle.putString("company", job.getCompany());
            bundle.putString("createdAt", job.getCreatedAt());
            bundle.putString("title", job.getTitle());
            bundle.putString("location", job.getLocation());
            bundle.putString("type", job.getType());
            bundle.putString("description", job.getDescription());
            bundle.putString("howToApply", job.getHowToApply());
            fragment.setArguments(bundle);
            return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detailed ");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //расположение наших вюшек
        companyLogo=view.findViewById(R.id.detail_companyLogo);
        company=view.findViewById(R.id.detail_company);
        createdAt=view.findViewById(R.id.detail_createdAt);
        title=view.findViewById(R.id.detail_title);
        location=view.findViewById(R.id.detail_location);
        type=view.findViewById(R.id.detail_type);
        description=view.findViewById(R.id.detail_description);
        howToApply=view.findViewById(R.id.detail_howToApply);
        try {
            //getArguments() возвращает аргументы, переданные в setArguments (Bundle) и мы берем каждое по ключу
            //меняем эти данные вюшек
            Picasso.get()
                    .load(getArguments().getString("companyLogo"))
                    .placeholder(R.drawable.image_placeholder)
                    .into(companyLogo);
            company.setText(getArguments().getString("company"));
            createdAt.setText(getArguments().getString("createdAt"));
            title.setText(getArguments().getString("title"));
            String desc=getArguments().getString("description");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            description.setText(Html.fromHtml(desc));
//            } else {
//                description.setText(Html.fromHtml(getArguments().getString("description")));
//            }
//            description.setText(HtmlCompat.fromHtml(desc, 0));
            location.setText(getArguments().getString("location"));
            type.setText(getArguments().getString("type"));
            description.setText(getArguments().getString("description"));
            howToApply.setText(getArguments().getString("howToApply"));
        }
        catch (Exception e) {
            Log.e("Error", e + " ");
        }
    }
}
