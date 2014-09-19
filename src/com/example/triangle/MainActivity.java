package com.example.triangle;

import com.example.triangleapp01.R;

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
// Calculate triangle type
  public void onButtonClick_Calc(View v)
    {
	  //variable declarations
	  
	  CharSequence cs_Type = "";
      EditText e1 = (EditText)findViewById(R.id.edit_sides);
      TextView t1 = (TextView)findViewById(R.id.text_msg);
      
      double db_array[] = new double[3];
      String str_array[] = new String[3];
      
      // check for empty text box
      if(e1.getText().toString().matches(""))
      {
      	DisplayMessage("Input value cannot be null.");
      }
      // extract values and send input for method
      else
      {
      	str_array = e1.getText().toString().split(",");
	        for (int count = 0; count < db_array.length ; count++) 
	        {
	        	db_array[count] = Double.parseDouble(str_array[count]);
	        }
	        cs_Type = CheckTraingle(db_array);        
	        t1.setText(cs_Type);
      }

    }
    public void onButtonClick_Clear(View v)
    {
    	EditText et = (EditText) findViewById(R.id.edit_sides);
        et.setText("");      
    }
    public void onButtonClick_Help(View v)
    {
    	DisplayMessage("Help");
    }
    public void DisplayMessage(String str_msg)
    {	
    	// This method displays message in a message box with only Ok button
    	AlertDialog.Builder alert_msg  = new AlertDialog.Builder(this);
    	alert_msg.setTitle("TriangleApp");
    	alert_msg.setPositiveButton("Ok",new DialogInterface.OnClickListener()
    	{
    		public void onClick(DialogInterface dialog, int which) 
    		{
      			
    		 }
    	});
    	alert_msg.setMessage(str_msg);
    	alert_msg.setCancelable(true);
		alert_msg.create().show();  	
    
    }
    public CharSequence CheckTraingle(double db_arrSides[])
    {
	   // declare variables
    	double db_side1,db_side2,db_side3;
	    db_side1 = db_arrSides[0];
	    db_side2 = db_arrSides[1];
	    db_side3=  db_arrSides[2];
		CharSequence cs_msg= "";
	    
		// check if input values form a triangle
		if ((db_side1 + db_side2 > db_side3)&& (db_side2 + db_side3 > db_side1) && (db_side1 + db_side3 > db_side2))
	    	{
				// check for equilateral (all 3 sides are equal)
				if (db_side1 == db_side2 && db_side2 == db_side3 && db_side1 == db_side3)
	    		{
	    			cs_msg = "Equilateral Triangle";
	    		}
	    		// check for isoceles ( only 2 sides are equal)
				else if (db_side1 == db_side2 || db_side2 == db_side3 || db_side3 == db_side1)
	    		{
	    			cs_msg ="Isoceles Traingle";
	    		}   		
	    	}
	    	else
	    	{
	    		cs_msg = "The input values cannot form a triangle";
	    	}
	    	return cs_msg;
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
