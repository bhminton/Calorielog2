package com.example.calorielog;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    TextView breakfast,amSnack,lunch,pmSnack,supper,nightSnack,exercise;

    EditText calorieLog,editTextBreakfast,editTextAmSnack,editTextLunch,editTextPmSnack,editTextSupper;
    EditText editTextNightSnack,editTextExercise,editTextDailyTotal;
    Button     button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView breakfast = (findViewById(R.id.breakfast));
        TextView amSnack = (findViewById(R.id.amSnack));
        TextView lunch = (findViewById(R.id.lunch));
        TextView pmSnack = (findViewById(R.id.pmSnack));
        TextView supper = (findViewById(R.id.supper));
        TextView nightSnack = (findViewById(R.id.nightSnack));
        TextView exercise = (findViewById(R.id.exercise));

        EditText calorieLog = (findViewById(R.id.calorieLog));
        EditText editTextBreakfast = (findViewById(R.id.editTextBreakfast));
        EditText editTextAmSnack = (findViewById(R.id.editTextAmSnack));
        EditText editTextLunch = (findViewById(R.id.editTextLunch));
        EditText editTextPmSnack = (findViewById(R.id.editTextPmSnack));
        EditText editTextSupper = (findViewById(R.id.editTextSupper));
        EditText editTextNightSnack = (findViewById(R.id.editTextNightSnack));
        EditText editTextExercise = (findViewById(R.id.editTextExercise));
        EditText editTextDailyTotal = (findViewById(R.id.editTextDailyTotal));

        Button button = (findViewById(R.id.button));
        System.out.println("editTextBreakfast.getText()");

        System.out.println(editTextBreakfast.getText());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etb=editTextBreakfast.getText().toString();
                 etas = String.valueOf(editTextAmSnack.getText());
         etl = String.valueOf(editTextLunch.getText());
        etps = String.valueOf(editTextPmSnack.getText());
        ets = String.valueOf(editTextSupper.getText());
    etns = String.valueOf(editTextNightSnack.getText());
         ete = String.valueOf(editTextExercise.getText());
//

                 etbi= parseInt(etb);
       etasi= parseInt(etas);
         etli= parseInt(etl);
        etpsi= parseInt(etps);
         etsi= parseInt(ets);
         etnsi= parseInt(etns);
         etei= parseInt(ete);
                  int total;
                total = ((etbi+etasi+etli+etpsi+etsi+etnsi)-etei);//-ete;
//                Toast.makeText(MainActivity.this,editTextBreakfast.getText(), Toast.LENGTH_LONG).show();
                //   calculateTotal();
                String dailyTotal = String.valueOf(total);
 editTextDailyTotal.setText(dailyTotal);
            }
        });
    }
     String etb;// = editTextBreakfast.getText().toString();
    String etas;// = String.valueOf(editTextAmSnack.getText());
      String etl ;//= String.valueOf(editTextLunch.getText());
      String etps; //= String.valueOf(editTextPmSnack.getText());
      String ets;// = String.valueOf(editTextSupper.getText());
      String etns ;//= String.valueOf(editTextNightSnack.getText());
       String ete; //= String.valueOf(editTextExercise.getText());
////
        int etbi;
        int etasi;
        int etli;
        int etpsi;
        int etsi;
        int etnsi;
        int etei;
//
////

        int total =(etbi+etasi+etli+etpsi+etsi+etnsi)-etei;


}
