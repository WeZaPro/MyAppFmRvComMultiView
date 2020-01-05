package com.taweesak.myappfmrvcommultiview;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Todo Step 3 ==> Create FM B
public class FragmentB extends Fragment {

    // get Agruments

    TextView tvCountry,tvRates,tvCalRates;
    ImageView imageView;
    EditText editText;
    Button button;

    double rateGet;
    double input;
    MyChidModel myChidModel = new MyChidModel();


    public FragmentB() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_b, container, false);
        findView(v);

        if(getArguments() != null){
            /*MyChidModel myChidModel = new MyChidModel();*/
            myChidModel = getArguments().getParcelable("key");

            rateGet = myChidModel.getRate();

            imageView.setImageResource(myChidModel.getImage());
            tvCountry.setText(myChidModel.getCountry());
            tvRates.setText(""+rateGet);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyChidModel myChidModel1 = new MyChidModel();
                    input = Double.parseDouble(editText.getText().toString());

                    myChidModel = new MyChidModel(rateGet,input);
                    tvCalRates.setText(""+myChidModel.getResult());
                }
            });
        }
        return v;
    }

    private void findView(View v) {
        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        tvCalRates = v.findViewById(R.id.tvCalRates);
        imageView = v.findViewById(R.id.imageView);
        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);
    }

}
