package com.example.helloworld;

import static org.junit.Assert.assertEquals;

import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest extends MainActivity{
    @Test
    public void testStudentNameIsDisplayed() {
        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(MainActivity -> {
                TextView text_display =MainActivity.findViewById(R.id.Name);
                assertEquals("Zhirui(Raymond) Xia",text_display.getText().toString());
                assertEquals(TextView.INVISIBLE,MainActivity.findViewById(R.id.Name).getVisibility());

            });
        }
//        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
//            scenario.onActivity(MainActivity -> {
//                assertEquals(TextView.INVISIBLE,MainActivity.findViewById(R.id.Name).getVisibility());
//            });
//        }
//        assertEquals("Zhirui(Raymond) Xia",new MainActivity().findViewById(R.id.Name));

//        assertEquals("name", findViewById(R.id.Name).toString());

//        TextView text_display = new MainActivity().findViewById(R.id.Name);
//        System.out.println(text_display);
    }
}
