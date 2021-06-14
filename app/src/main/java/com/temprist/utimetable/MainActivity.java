package com.temprist.utimetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import org.w3c.dom.Text;

import java.nio.file.attribute.FileAttributeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation Menu
        {
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

            findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

            NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
            navigationView.setItemIconTintList(null);

            NavController navController = (NavController) Navigation.findNavController(this, R.id.navHostFragment);
            NavigationUI.setupWithNavController(navigationView, navController);

            TextView textTitle = (TextView) findViewById(R.id.textViewTitle);

            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                    textTitle.setText(destination.getLabel());
                }
            });
        }

        //Speed Dial
        {
            SpeedDialView speedDialView = (SpeedDialView) findViewById(R.id.speedDialView);

            speedDialView.addActionItem(
                    new SpeedDialActionItem.Builder(R.id.addAssignmentFAB, R.drawable.ic_baseline_post_add_24)
                            .setFabBackgroundColor(getColor(R.color.Primary))
                            .setLabel(getString(R.string.addAssignment))
                            .setLabelClickable(false)
                            .create()
            );

            speedDialView.addActionItem(
                    new SpeedDialActionItem.Builder(R.id.addClassFAB, R.drawable.ic_baseline_add_to_photos_24)
                            .setFabBackgroundColor(getColor(R.color.Primary))
                            .setLabel(getString(R.string.addClass))
                            .setLabelClickable(false)
                            .create()
            );

            speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
                @Override
                public boolean onActionSelected(SpeedDialActionItem speedDialActionItem) {
                    if (speedDialActionItem.getId() == R.id.addClassFAB) {
                        startActivity(new Intent(MainActivity.this, addClass.class));
                        return false;
                    }
                    else if (speedDialActionItem.getId() == R.id.addAssignmentFAB) {
                        startActivity(new Intent(MainActivity.this, addAssignment.class));
                        return false;
                    }
                    return false;
                }
            });
        }
    }
}