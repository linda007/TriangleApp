package com.example.triangle;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et = (EditText) findViewById(R.id.edit_sides);
       
        et.setOnKeyListener(new OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                	 switch (keyCode)
                     {
                	 // enter key press
                     	case KeyEvent.KEYCODE_ENTER:
                    	 Calculate();
                    	 break;
                     	 // zero key press
                     	case KeyEvent.KEYCODE_0:
                         	if(et.getText().toString().matches(""))
                         	DisplayMessage("The End" ,1);
                          default:
                             break;
                     }
                }
                return false;
            }
        }
    );
    }
   
   
// Calculate triangle type
  public void onButtonClick_Calc(View v)
    {
	  Calculate();
    }
  
  public void onButtonClick_Clear(View v)
  {
  	ClearFields();
  }
  
   public void ClearFields()
  {
  	// clear all text fields
	  EditText et = (EditText) findViewById(R.id.edit_sides);
      et.setText("");    
      TextView t1 = (TextView)findViewById(R.id.text_msg);
      t1.setText("Output_Message");
  }
  
  public void DisplayMessage(String str_msg, int int_case)
    {	
    	// This method displays message in a message box with only Ok button
    	AlertDialog.Builder alert_msg  = new AlertDialog.Builder(this);
    	alert_msg.setTitle("TriangleApp");
    	if(int_case == 1)
    	{
	    	alert_msg.setPositiveButton("Ok",new DialogInterface.OnClickListener()
	    	{
	    		public void onClick(DialogInterface dialog, int which) 
	    		{
	    			// equivalent to pressing the back button
	    			ClearFields();
	    			moveTaskToBack(true);
	    		 }
	    	});
    	}
    	else if ( int_case == 2)
    	{
    		alert_msg.setPositiveButton("Ok",new DialogInterface.OnClickListener()
        	{
        		public void onClick(DialogInterface dialog, int which) 
        		{
        			ClearFields();
        		 }
        	});
    	}
    	else if ( int_case == 3)
    	{
    		alert_msg.setPositiveButton("Ok",new DialogInterface.OnClickListener()
        	{
        		public void onClick(DialogInterface dialog, int which) 
        		{
        			
        		 }
        	});
    	}
    	alert_msg.setMessage(str_msg);
    	alert_msg.setCancelable(true);
		alert_msg.create().show();  	
    
    }
  
  public void Calculate()
  {
  	//variable declarations
	    CharSequence cs_Type = "";
      EditText e1 = (EditText)findViewById(R.id.edit_sides);
      TextView t1 = (TextView)findViewById(R.id.text_msg);
                 
      // check for empty text box
      if(e1.getText().toString().matches(""))
      {
      	DisplayMessage("Input value cannot be null.",2);
      }
      // extract values and send input for method
      else
      {
    	  
    	  int int_index = e1.getText().toString().indexOf(',');
    	  if(int_index > 0)
    	  {
    		  String str_array[] = e1.getText().toString().split(",");
    		  double db_array[] = new double[3];
    		  int int_counter = 0;
    		  if(str_array.length == 3)
		      	{
          		   for (int count = 0; count < str_array.length ; count++) 
    		        {
    		        	if( str_array[count].toString().equals("") == false)
    		        	{
    		        		db_array[count] = Double.parseDouble(str_array[count]);
    		        		int_counter++;
    		        	}  		        		
    		        }
          		   if (int_counter == 3)
          		   {
	    	      		cs_Type = CheckTraingle(db_array);        
	    				t1.setText(cs_Type);
          		   }
          		   else
          		   {
          			 DisplayMessage("Invalid Input: Input should be 3 numbers.",2);
          		   }
		      	}
	    		else
			    {
			      	DisplayMessage("Invalid Input: Input should be 3 numbers.",2);
			    }
    	  }
    	  else
		  {
		      	DisplayMessage("Invalid Input: Input should be 3 numbers.",2);
		  }
      }
  }
  public CharSequence CheckTraingle(double db_arrSides[])
    {
	   // declare variables
    	double db_side1,db_side2,db_side3;
	    db_side1 = db_arrSides[0];
	    db_side2 = db_arrSides[1];
	    db_side3=  db_arrSides[2];
		CharSequence cs_msg= "";
	    
		if (db_side1 > 0 && db_side2 > 0 && db_side3 > 0)
		{
		//* Range 1 -100
			if ((db_side1 >= 1 && db_side1 <= 100) && (db_side2 >= 1 && db_side2 <= 100) && (db_side3 >= 1 && db_side3 <= 100))
			{
			    // check if input values form a triangle
				if ((db_side1 + db_side2 > db_side3)&& (db_side2 + db_side3 > db_side1) && (db_side1 + db_side3 > db_side2))
		    	{
					// check for equilateral (all 3 sides are equal)
					if (db_side1 == db_side2 && db_side2 == db_side3 && db_side1 == db_side3)
		    		{
		    			cs_msg = "Equilateral";
		    		}
		    		// check for isosceles ( only 2 sides are equal)
					else if (db_side1 == db_side2 || db_side2 == db_side3 || db_side3 == db_side1)
		    		{
		    			cs_msg ="Isosceles";
		    		} 
					//check for scalene triangle
					else
					{
						cs_msg = "Scalene";
					}
		    	}
		    	else
		    	{
		    		cs_msg = "The input values cannot form a triangle";
		    	}
			}
			else
			{
				cs_msg = "Input should be within 1-100 range.";
				//DisplayMessage("Input should be 1-100 range.");
			}
		}
		else
		{
			DisplayMessage("Input should be within 1-100 range",2);
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
