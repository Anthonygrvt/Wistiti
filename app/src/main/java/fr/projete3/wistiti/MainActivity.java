package fr.projete3.wistiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements NavFragment.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();
        NavFragment navFragment = new NavFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.Content,homeFragment)
                .add(R.id.Nav,navFragment)
                .commit();
    }

    @Override // for nested class MenuFragment.onItemClickListener
    public void onItemSelected(int btnpress) {

        if (btnpress==1){
            HomeFragment homeFragment = new HomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Content, homeFragment)
                    .commit();
        }

        else if (btnpress==2){
            MenuFragment menuFragment = new MenuFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Content, menuFragment)
                    .commit();
        }

        else if (btnpress==3){
            AddFragment addFragment = new AddFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Content, addFragment)
                    .commit();
        }

        // Replace the current fragment with a new one
    }

}