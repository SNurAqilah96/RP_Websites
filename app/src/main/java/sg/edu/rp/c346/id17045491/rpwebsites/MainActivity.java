package sg.edu.rp.c346.id17045491.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //Declare the variables
    Spinner Spn1Menu;
    Spinner Spn2Submenu;
    Button btnGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind or Link
        Spn1Menu = findViewById(R.id.spinner1);
        Spn2Submenu= findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        //Initialise the Array List
        alCategory= new ArrayList<>();

        // This is Approach 2: Load it from the string array defined earlier
        //Get the string-array and store as an Array
        String[] strCategory = getResources().getStringArray(R.array.Category);

        //Convert Array to List and add to the ArrayList
        alCategory.addAll(Arrays.asList(strCategory));


        //Create an ArrayAdapter using the default spinner layout
        aaCategory = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alCategory);

        //Bind the ArrayAdapter to the spinner
        Spn1Menu.setAdapter(aaCategory);


        //Automatic Update of the Spinner
        Spn1Menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] strCategory;
                switch (position){

                    case 0:
                        // Your code for item 1 selected
                        strCategory= getResources().getStringArray(R.array.Category);

                        Spn2Submenu.setSelection(0);




                        break;
                    case 1:
                        // Your code for item 1 selected
                        strCategory = getResources().getStringArray(R.array.SubCategory);


                        {Spn2Submenu.setSelection(2);}


                        break;
                }
                aaCategory.notifyDataSetChanged();
            }






            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });









        //Implement the button onClick () method
        // to load the display webpage of the corresponding URL
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alCategory.clear();


                String url = " ";
                //Determine the correct URL to set
                if (Spn1Menu.getSelectedItemPosition() == 0) {
                    if (Spn2Submenu.getSelectedItemPosition() == 0) {
                        url = "https://www.rp.edu.sg/";
                    } else if (Spn2Submenu.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/student-life";
                    }
                } else if (Spn1Menu.getSelectedItemPosition() == 1) {

                    if (Spn2Submenu.getSelectedItemPosition() == 2) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";

                    } else if (Spn2Submenu.getSelectedItemPosition() == 3) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("URL", url);
                startActivity(intent);
            }
        });

    }
}
