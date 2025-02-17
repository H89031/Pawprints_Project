package com.example.pawprints

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.telephony.PhoneNumberUtils
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class Signup() : AppCompatActivity() {


    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val loggingIn: Button = findViewById(R.id.signedup)


        val name = findViewById<EditText>(R.id.name)
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val bday = findViewById<EditText>(R.id.birthdate)
        val phonenum = findViewById<EditText>(R.id.phone)
        val address = findViewById<EditText>(R.id.city)
        val password = findViewById<EditText>(R.id.password)
        val con_password = findViewById<EditText>(R.id.confirm_pass)

        bday.setOnClickListener {

            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting
            // our day, month and year.
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    bday.setText(dat)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()
        }
        fun convertToSqlDate(dateString: String): java.sql.Date {
            return try {
                // Parse the date in the format "dd-MM-yyyy"
                val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val parsedDate = format.parse(dateString)

                // Ensure the parsed date is not null, and return java.sql.Date
                parsedDate?.let {
                    java.sql.Date(it.time)
                } ?: throw IllegalArgumentException("Invalid date format")
            } catch (e: Exception) {
                // Handle invalid date parsing, throw exception or log the error
                e.printStackTrace()
                throw IllegalArgumentException("Invalid date format")
            }
        }
        loggingIn.setOnClickListener {
            ///FIX THIS
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(applicationContext)
                val userDao = db.usersDao()

                if(name.text.isNotEmpty()&&username.text.isNotEmpty()&&email.text.isNotEmpty()&&
                    bday.text.isNotEmpty()&&phonenum.text.isNotEmpty()&&address.text.isNotEmpty()&&
                    password.text.isNotEmpty()){

                    val birthDate = convertToSqlDate(bday.text.toString())

                    if ((con_password.text.toString() != password.text.toString())){
                        con_password.error = "Input your Password Again"
                    }
                    else {
                        val User: Unit = userDao.insertUser(
                            Users(
                                0,
                                fullname = name.text.toString(),
                                username = username.text.toString(),
                                email = email.text.toString(),

                                bday = birthDate,
                                phonenum = phonenum.text.toString(),
                                address = address.text.toString(),
                                password = password.text.toString()
                            )
                        )
                        finish()
                    }
                }else{
                    if (name.text.isEmpty()){
                        name.error = "Input your Fullname"
                    }
                    if (username.text.isEmpty()){
                        username.error = "Input your Username"
                    }
                    if (email.text.isEmpty()){
                        email.error = "Input your Email"
                    }
                    if (bday.text.isEmpty()){
                        bday.error = "Input your Birthdate"
                    }
                    if (phonenum.text.length != 11){
                        phonenum.error = "Input your Phone Number"
                    }
                    if (address.text.isEmpty()){
                        address.error = "Input your City"
                    }
                    if (password.text.isEmpty()){
                        password.error = "Input your Password"
                    }
                    if (con_password.text.isEmpty()){
                        con_password.error = "Input your Password Again"
                    }

                }
                val users: List<Users> = userDao.getAllUsers()
            }


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}