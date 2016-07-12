package com.example.cc15.anwesha2017.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.cc15.anwesha2017.R;

import java.util.Calendar;

//import com.example.cc15.anwesha2017.R;

public class RegistrationActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private EditText Name,Contact,College,City;
    private EditText DOB;
    private AutoCompleteTextView Email;
    private RadioButton sex_male,sex_female;
    private char user_sex;
    private Button Register;
    ImageView Calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DOB = (EditText) findViewById(R.id.et_dob);
        Name = (EditText) findViewById(R.id.et_name);
        Email = (AutoCompleteTextView) findViewById(R.id.email);
        Contact = (EditText) findViewById(R.id.et_mobile);
        College = (EditText) findViewById(R.id.et_college);
        City = (EditText) findViewById(R.id.et_city);
        sex_male = (RadioButton) findViewById(R.id.rb_sex_male);
        sex_female = (RadioButton) findViewById(R.id.rb_sex_female);
        Register = (Button) findViewById(R.id.b_register);
        Calender = (ImageView) findViewById(R.id.calender_button);

        sex_female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    sex_male.setChecked(false);
                    user_sex = 'F';
                }
            }
        });

        sex_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    sex_female.setChecked(false);
                    user_sex = 'M';
                }
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

    }


    public class DatePickerExample extends Activity {
        private int mYear;
        private int mMonth;
        private int mDay;
        static final int DATE_DIALOG_ID = 1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Calender.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showDialog(DATE_DIALOG_ID);
                }
            });
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            updateDisplay();
        }
        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DATE_DIALOG_ID:
                    return new DatePickerDialog(this,
                            mDateSetListener,
                            mYear, mMonth, mDay);
            }
            return null;
        }
        protected void onPrepareDialog(int id, Dialog dialog) {
            switch (id) {
                case DATE_DIALOG_ID:
                    ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
                    break;
            }
        }
        private void updateDisplay() {
            DOB.setText(
                    new StringBuilder()
                            // Month is 0 based so add 1
                            .append(mMonth + 1).append("-")
                            .append(mDay).append("-")
                            .append(mYear).append(" "));
        }
        private DatePickerDialog.OnDateSetListener mDateSetListener =
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        mYear = year;
                        mMonth = monthOfYear;
                        mDay = dayOfMonth;
                        updateDisplay();
                    }
                };}

    private static String isCityValid(String name) {
        if (name.length() == 0)
            return "City can't be Empty";
        if (name.length() > 25)
            return "Too long for City";
        return null;
    }
    private static String isCollegeValid(String name) {
        if (name.length() == 0)
            return "College can't be Empty";
        if (name.length() > 25)
            return "Too long for College";
        return null;
    }
    private static String isContactValid(String name) {
        if (name.length() == 0)
            return "Contact can't be Empty";
        if (name.length()> 11)
            return "Too long for Contact";
        else if(name.length()<10)
            return "Too short for contact";
        return null;
    }
    private static String isNameValid(String name) {
        if (name.length() == 0)
            return "Name can't be Empty";
        if (name.length() > 40)
            return "Too long for Name";
        return null;
    }
    private static boolean isEmailValid(String email) {
        return email.contains("@");
    }



    private void attemptRegister() {

        // Reset errors.
        Email.setError(null);
        Name.setError(null);
        DOB.setError(null);
        College.setError(null);
        Contact.setError(null);
        City.setError(null);

        // Store values at the time of the login attempt.
        String email = Email.getText().toString();
        String name = Name.getText().toString();
        String dob = DOB.getText().toString();
        String city = City.getText().toString();
        String college = College.getText().toString();
        String contact = Contact.getText().toString();


        View focusView = null;

        String customErrorMessage;

        if ((customErrorMessage = isNameValid(name)) != null) {
            Name.setError(customErrorMessage);
            focusView = Name;
        }else if (TextUtils.isEmpty(email)) {
            Email.setError("This Field is required");
            focusView = Email;
        } else if (!isEmailValid(email)) {
            Email.setError("Invalid E-mail");
            focusView = Email;
        } else if ((customErrorMessage = isContactValid(contact)) != null) {
            Contact.setError(customErrorMessage);
            focusView = Contact;
        }else if ((customErrorMessage = isCollegeValid(college)) != null) {
            College.setError(customErrorMessage);
            focusView = College;
        } else if ((customErrorMessage = isCityValid(city)) != null) {
            City.setError(customErrorMessage);
            focusView = City;
        }

        if (focusView != null) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true, mLoginFormView, mProgressView, getResources());
            //tryRegister(email,name,contact,college,dob,city);
        }
    }

    /*void tryRegister(String email, String name, String mobile, String college, String dob, String city) {
        ArrayList<Pair<String, String>> param = new ArrayList<>();
        param.add(new Pair<String, String>("name", name));
        param.add(new Pair<String, String>("mobile", mobile));
        param.add(new Pair<String, String>("sex", String.valueOf(user_sex)));
        param.add(new Pair<String, String>("college", college));
        param.add(new Pair<String, String>("email", email));
        param.add(new Pair<String, String>("dob", dob));
        param.add(new Pair<String, String>("city", city));

        //MyHttpClient client = new MyHttpClient(BackgroundFetch.BASE_URL + "/user/register/User", param, true, new MyHttpClientListener() {
            @Override
            public void onPreExecute() {

            }

            @Override
            public void onFailed(Exception e) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Login")
                        .setPositiveButton("Ok",null)
                        .setMessage("Lost Connection!");
                dialog.create().show();

                showProgress(false, mLoginFormView, mProgressView, getResources());
            }

            @Override
            public void onSuccess(Object output) {
                String result = (String) output;
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Registration")
                        .setMessage("Some Error Occured!")
                        .setPositiveButton("Ok",null);
                try {
                    JSONArray array = new JSONArray(result);
                    int status = array.getInt(0);
                    if(status==1)
                    {
                        JSONObject obj = array.getJSONObject(1);
                        City.setText(null);
                        Name.setText(null);
                        College.setText(null);
                        Contact.setText(null);
                        DOB.setText(null);
                        dialog.setMessage("Your Anwesha ID : ANW"+obj.getInt("pId"));


                    }
                    else
                    {
                        dialog.setMessage(array.getString(1));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dialog.create().show();
                //showProgress(false, mLoginFormView, mProgressView, getResources());
            }

            @Override
            public void onBackgroundSuccess(String result) {

            }
        });
    }*/



}
