package com.example.smrutimukundvarvadekar.animal_app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class BuyAnimalActivity extends AppCompatActivity  {
    public Button buttonNext,buttonBack;
    AnimalDetailsFragment animalDetailsFragment;
    EnvironmentDetailsFragment environmentDetailsFragment;
    FeedDetailsFragment feedDetailsFragment;
    OtherDetailsFragment otherDetailsFragment;
    YieldDetailsFragment yieldDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_animal);
        animalDetailsFragment=new AnimalDetailsFragment();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.ll_buy_animal_main, animalDetailsFragment, null).
                addToBackStack(null).commit();
        buttonNext=(Button)findViewById(R.id.button_next_main);
        buttonBack=(Button)findViewById(R.id.button_back_main);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.ll_buy_animal_main);
                if(fragment instanceof AnimalDetailsFragment){
                    environmentDetailsFragment=new EnvironmentDetailsFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, environmentDetailsFragment, null).
                            addToBackStack(null).commit();
                }
                else if(fragment instanceof EnvironmentDetailsFragment){
                    feedDetailsFragment=new FeedDetailsFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, feedDetailsFragment , null).
                            addToBackStack(null).commit();
                }
                else if(fragment instanceof FeedDetailsFragment){
                    yieldDetailsFragment=new YieldDetailsFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, yieldDetailsFragment , null).
                            addToBackStack(null).commit();
                }
                else if(fragment instanceof YieldDetailsFragment){
                    otherDetailsFragment=new OtherDetailsFragment();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, otherDetailsFragment , null).
                            addToBackStack(null).commit();
                }
                else if(fragment instanceof OtherDetailsFragment){
                    Toast.makeText(BuyAnimalActivity.this,"Details Submitted Successfully",Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.ll_buy_animal_main);
                if(fragment instanceof EnvironmentDetailsFragment){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main,animalDetailsFragment, null).
                            addToBackStack(null).commit();

                }
                else if(fragment instanceof FeedDetailsFragment){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, environmentDetailsFragment , null).
                            addToBackStack(null).commit();
                }
                else if(fragment instanceof OtherDetailsFragment){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.ll_buy_animal_main, feedDetailsFragment , null).
                            addToBackStack(null).commit();
                }
            }
        });
    }
}