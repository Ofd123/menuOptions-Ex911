package com.example.menuoptions;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText originalNumber,functioningNumber;
    TextView resultNumber;
    String num1str,num2str;
    double num1,num2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    originalNumber = findViewById(R.id.num1);
    functioningNumber = findViewById(R.id.num2);
    resultNumber = findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean isValie(String num)
    {
        if(num == null || num.equals("+") || num.equals("-") || num.equals(" ") || num.equals(".") || num.equals("+.") || num.equals("-.") || num.equals(" .") || num.equals("+-") || num.equals("-+") || num.equals("+-.") || num.equals("-+.") || num.equals("") || num.equals(" "))
        {
            Toast.makeText(this, "invalid input", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        String command = item.getTitle().toString();
        ;
        num1str = originalNumber.getText().toString();
        num2str = functioningNumber.getText().toString();
        if (isValie(num1str) && isValie(num2str))
        {
            if (command.equals("add"))
            {
                num1 = Double.parseDouble(num1str);
                num2 = Double.parseDouble(num2str);
                resultNumber.setText(String.valueOf(num1 + num2));
            }
            else if (command.equals("decrease"))
            {
                num1 = Double.parseDouble(num1str);
                num2 = Double.parseDouble(num2str);
                resultNumber.setText(String.valueOf(num1 - num2));
            }
            else if (command.equals("multiply"))
            {
                num1 = Double.parseDouble(num1str);
                num2 = Double.parseDouble(num2str);
                resultNumber.setText(String.valueOf(num1 * num2));
            }
            else if (command.equals("divide"))
            {
                num1 = Double.parseDouble(num1str);
                num2 = Double.parseDouble(num2str);
                resultNumber.setText(String.valueOf(num1 / num2));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}