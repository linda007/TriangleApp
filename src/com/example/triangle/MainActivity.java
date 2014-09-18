package com.example.triangle;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick_Calc(View v)
    {
        CharSequence thesum = "";
        EditText e1 = (EditText)findViewById(R.id.edit_sides);
        TextView t1 = (TextView)findViewById(R.id.text_msg);
        int intarray[] = new int[3];
        String strarray[] = new String[3];
        strarray = e1.getText().toString().split(",");
        for (int count = 0; count < intarray.length ; count++) 
        {
            intarray[count] = Integer.parseInt(strarray[count]);
            thesum=CheckTraingle(intarray);
        }
                 
        t1.setText(thesum);
    }
    public void onButtonClick_Clear(View v)
    {
    	EditText et = (EditText) findViewById(R.id.edit_sides);
        et.setText("");
        
    }
    public void onButtonClick_Help(View v)
    {
    	AlertDialog.Builder alert_msg  = new AlertDialog.Builder(this);
    	alert_msg.setTitle("TriangleApp");
    	alert_msg.setPositiveButton("Ok",new DialogInterface.OnClickListener()
    	{
    		@Override
			public void onClick(DialogInterface dialog, int which) 
    		{
      			
    		 }
    	});
    	alert_msg.setMessage("Trial message");
    	alert_msg.setCancelable(true);
		alert_msg.create().show();  
    }
    
public CharSequence CheckTraingle(int arrSides[])
    {
    int a,b,c;
    a=arrSides[0];
    b=arrSides[1];
    c=arrSides[2];
	CharSequence s= "";
    	if ((a + b > c)&& (b+c>a) && (a+c>b))
    	{
    		if (a==b && b==c && a==c)
    		{
    			s="Equilateral Triangle";
    		}
    		else if (a==b || b==c || c==a)
    		{
    			s="Isoceles Traingle";
    		}
    		else
    		 s = "Scalene Triangle";
    		
    	}
    	else
    	{
    		s="The input values cannot form a triangle";
    	}
    	return s;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
