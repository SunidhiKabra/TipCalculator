package com.example.sunidhi.hw01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText bill_amount_editText, tip_value_editText, total_editText;
    RadioGroup rg;
    SeekBar seekBar;
    TextView percent_textView;
    RadioButton rb;
    int percentForRB;
    Double billAmount = 0.0, tip = 0.0, total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        bill_amount_editText= findViewById( R.id.bill_amount_editText );
        tip_value_editText = findViewById( R.id. tip_value_editText);
        total_editText = findViewById( R.id.total_editText );
        rg = findViewById( R.id.radioGroup2 );
        seekBar = findViewById( R.id.custom_seekBar );
        percent_textView = findViewById( R.id.percent_textView );
        seekBar.setEnabled( false );

        rg.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb = findViewById( i );
                String val = rb.getText().toString();
                if (val.matches( "10%" )){
                    percentForRB = 10;
                    if(billAmount != 0.0 && percentForRB != 0){
                        tip = (percentForRB / billAmount) * 100;
                        total = tip + billAmount;

                        tip_value_editText.setText( tip.toString() );
                        total_editText.setText( total.toString() );
                    }
                }
                else if (val.matches( "15%" )){
                    percentForRB = 15;
                    if(billAmount != 0.0 && percentForRB != 0){
                        tip = (percentForRB / billAmount) * 100;
                        total = tip + billAmount;

                        tip_value_editText.setText( tip.toString() );
                        total_editText.setText( total.toString() );
                    }
                }
                else if (val.matches( "18%" )){
                    percentForRB = 18;
                    if(billAmount != 0.0 && percentForRB != 0){
                        tip = (percentForRB / billAmount) * 100;
                        total = tip + billAmount;

                        tip_value_editText.setText( tip.toString() );
                        total_editText.setText( total.toString() );
                    }
                }
                else if (val.matches( "Custom" )){
                    Log.d( "demo", "inside custom" );
                    seekBar.setEnabled( true );
                    percentForRB = 25;
                    seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            percentForRB = i;
                            percent_textView.setText(String.valueOf(seekBar.getProgress()) + " % ");
                            if(billAmount != 0.0 && percentForRB != 0){
                                tip = (percentForRB / billAmount) * 100;
                                total = tip + billAmount;

                                tip_value_editText.setText( tip.toString() );
                                total_editText.setText( total.toString() );
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    } );
                }
            }
        } );

        if (bill_amount_editText.getText().toString().matches( "" )){
            bill_amount_editText.setError( "Enter Bill Amount" );
        }


        bill_amount_editText.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bill_amount_editText.getText().toString().matches( "" )){
                    bill_amount_editText.setError( "Enter Bill Amount" );
                }
                else{
                    billAmount = Double.parseDouble( bill_amount_editText.getText().toString() );
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(billAmount != 0.0 && percentForRB != 0){
                    tip = (percentForRB / billAmount) * 100;
                    total = tip + billAmount;

                    tip_value_editText.setText( tip.toString() );
                    total_editText.setText( total.toString() );
                }
            }
        } );
    }
}
