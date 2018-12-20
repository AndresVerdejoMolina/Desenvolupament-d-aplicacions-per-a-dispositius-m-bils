package com.example.jcmilena.apptomodify1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControllerActivity extends AppCompatActivity implements EasyFragment.fraguno {

    String fragment_number = "1";
    int fragment_color = R.color.colorFragment1;
    int fragment_color2 = R.color.colorPrimary;
    int fragment_container = R.id.fragment_container1;
    int fragment_container2 = R.id.fragment_container2;
    String fragment_tag = "Frag1";
    String fragment_tag2 = "Frag2";
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null) {
            fragment_number = savedInstanceState.getString("numero");
            fragment_color = savedInstanceState.getInt("color");
            fragment_tag = savedInstanceState.getString("tag");
            fragment_container = savedInstanceState.getInt("1");
        }
        setContentView(R.layout.activity_controller);

        Fragment newFragment= EasyFragment.newInstance(fragment_number,fragment_color);
        fm.beginTransaction().replace(fragment_container, newFragment,fragment_tag).commit();

    }
    public void pulsado(String numero) {
        if(numero.equalsIgnoreCase("1")){
            Fragment fragmentToRemove = fm.findFragmentByTag("Frag1");

            fm.beginTransaction().remove(fragmentToRemove).commit();

            int fragment_color2 = R.color.colorPrimary;
            int fragment_container2 = R.id.fragment_container2;
            String fragment_tag2 = "Frag2";


        }else{ Fragment fragmentToRemove2 = fm.findFragmentByTag("Frag2");

            fm.beginTransaction().remove(fragmentToRemove2).commit();
            int fragment_color = R.color.colorPrimary;
            int fragment_container = R.id.fragment_container2;
            String fragment_tag = "Frag2";

            fragment_number="2";
        }
        Fragment newFragment= EasyFragment.newInstance(fragment_number, fragment_color);
        fm.beginTransaction().replace(fragment_container, newFragment,fragment_tag).commit();

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putString("numero", fragment_number);
        outState.putInt("color", fragment_color);
        outState.putInt("container", fragment_container);
        outState.putString("tag", fragment_tag);
        super.onSaveInstanceState(outState);

    }

}
