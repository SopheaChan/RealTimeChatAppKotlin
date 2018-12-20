package com.example.dell.hellokt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dell.hellokt.loginRepository.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()
        btnLogin.setOnClickListener{
            onLogin()
        }
        textGoToSignUpPage.setOnClickListener{
            goToSignUpActivity()
        }
    }

    private fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    private fun onLogin() {
        val email: String = etEmail.text.toString().trim()
        val password: String = etPassword.text.toString().trim()
        val validation: Boolean = isLoginDataInputValid(email, password)
        if (validation){
            var email: String = etEmail.text.toString().trim()
            var password: String = etPassword.text.toString().trim()
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("singup", "createUserWithEmail:success")
                        val user = firebaseAuth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("signup", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }

                    // ...
                }

            /*
                *
                *
                *
                *
            */
        }
        else {
            val errorMessage: String = isLoginDataInputNotValid(email, password)
            textErrorAlert.text = errorMessage
        }
    }
}
