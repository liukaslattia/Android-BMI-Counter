package fi.tuni.BMICounter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends MyBaseActivity {
    EditText mass;
    EditText height;
    Button calculate;
    TextView textfield;
    String bmiCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Debug.loadDebug(this);
        Log.d("fi.tuni.exercise2", "Logging my application.");
        // adb logcat fi.tuni.exercise2:D *:S

        // Init EditText fields and button
        mass = (EditText) findViewById(R.id.mass);
        height = (EditText) findViewById(R.id.height);
        calculate = (Button) findViewById(R.id.button);
        textfield = (TextView) findViewById(R.id.textfield);

        // calculates bmi when clicked
        calculate.setOnClickListener((v) -> {

            String heightstring = height.getText().toString();
            String massstring = mass.getText().toString();

            // for debugging purposes
            if (Debug.toastDebug() == true) {
                Context context = getApplicationContext();
                CharSequence text = "DEBUG";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
            } else {
                Debug.print(TAG, "clicked", 1);
            }


            // checks EditText fields and returns error if empty
            if (TextUtils.isEmpty(heightstring)) {
                height.setError("Cannot be empty");
                return;
            }

            if (TextUtils.isEmpty(massstring)) {
                mass.setError("Cannot be empty");
                return;
            }
            Double heightvalue = Double.parseDouble(heightstring);
            Double massvalue = Double.parseDouble(massstring);

            // calculates bmi
            Double bmi = ((massvalue / heightvalue / heightvalue) * 10000);

            // rounds bmi to one decimal value
            String str = String.format("%1.2f", bmi);
            bmi = Double.valueOf(str);

            // checks bmi and assigns bmi category
            if (bmi < 18.5) {
                bmiCategory = "Underweight";

            } else if (bmi >= 18.5 && bmi < 25) {
                bmiCategory = "Normal weight";

            } else if (bmi >= 25 && bmi < 30) {
                bmiCategory = "Overweight ";

            } else if (bmi >= 30) {
                bmiCategory = "Obesity ";

            }

            // displays bmi and category to textfield
            textfield.setText("BMI: " + bmi.toString() + " BMI Category: " +
                    bmiCategory);
        });


    }

}
