package com.example.iitcount;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText editText;
	private Button button;
	private TextView textViewShowPersonalIncome;
	private TextView textViewShowIIT;
	private TextView textViewShowAfterIncome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {

		editText = (EditText) findViewById(R.id.editText_input);
		button = (Button) findViewById(R.id.button_count);
		textViewShowPersonalIncome = (TextView) findViewById(R.id.textView_show_personal_income);
		textViewShowIIT = (TextView) findViewById(R.id.textView_show_IIT);
		textViewShowAfterIncome = (TextView) findViewById(R.id.textView_after_incmoe);

		button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		String input = editText.getText().toString();
		
		if (input.trim().length() == 0) {

			Toast.makeText(this, "请输入月收入", Toast.LENGTH_LONG).show();

		} else {
			
			double personalIncome = Double.valueOf(editText.getText().toString());
			double tax = personalIncome - 3500;
			double IIT;
			
			if (tax <= 0) {
				IIT = 0;
			} else if (tax <= 1500) {
				IIT = tax * 0.03;
			} else if (tax <= 4500) {
				IIT = tax * 0.1 - 105;
			} else if (tax <= 9000) {
				IIT = tax * 0.2 - 555;
			} else if (tax <= 35000) {
				IIT = tax * 0.25 - 1005;
			} else if (tax <= 55000) {
				IIT = tax * 0.3 - 2755;
			} else if (tax <= 80000) {
				IIT = tax * 0.35 - 5505;
			} else {
				IIT = tax * 0.45 - 13505;
			}
			
			double afterIncome = personalIncome - IIT;
			
			textViewShowPersonalIncome.setText("您的月收入为:" + personalIncome + "(元)");
			textViewShowIIT.setText("应缴纳个人所得税额为:" + IIT + "(元)");
			textViewShowAfterIncome.setText("税后收入为:" + afterIncome + "(元)");
			
			editText.setText("");
		}

	}

}
