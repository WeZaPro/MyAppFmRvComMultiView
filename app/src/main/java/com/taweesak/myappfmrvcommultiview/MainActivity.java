package com.taweesak.myappfmrvcommultiview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyListener{
    // set add Fragment
    // implement Interface
    // getData from Interface(Bundle) + setAgruments
    // replace FM



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_top,fragmentA)
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_bottom,fragmentB)
                    .commit();
        }
    }

    @Override
    public void myCallback(MyChidModel myChidModel) {

        FragmentB fragmentB = new FragmentB(); // ต้องสร้าง instance ใน Class เท่านั้น
        Bundle b = new Bundle();
        b.putParcelable("key",myChidModel);
        fragmentB.setArguments(b);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer_bottom,fragmentB)
                .addToBackStack("")
                .commit();
    }
}
