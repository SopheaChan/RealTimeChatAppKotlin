package com.example.dell.hellokt.loginRepository

import android.content.Context
import android.widget.Toast

fun isLoginDataInputValid(email:String, password: String): Boolean{
    return email.contains("@") && password.length>=6
}
fun isLoginDataInputNotValid(email: String, password: String): String{
    var errorMessage: String = ""
    if (email.isEmpty() || password.isEmpty()){
        errorMessage = "please input all the required information"
    }
    else if (!email.contains("@")){
        errorMessage = "Please input the correct form of email."
    }
    else if (password.length<6) {
        errorMessage = "Your password must contain at least 6 characters"
    }
    return errorMessage
}
fun isSignUpDataInputValid(username: String, email: String, password: String, confirmedPassword: String){

}
fun toast(context: Context, msg: String) {
    Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
}
