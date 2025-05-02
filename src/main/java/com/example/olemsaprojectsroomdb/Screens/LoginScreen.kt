package com.example.olemsaprojectsroomdb.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.olemsaprojectsroomdb.viewmodel.UserViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    userViewModel: UserViewModel = viewModel()
) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E7D32)) // Green
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (isRegistering) "Register" else "Login",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.LightGray,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )

        )


        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.LightGray,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )

        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (isRegistering) {
                    userViewModel.register(username, password) { success ->
                        if (success) {
                            Toast.makeText(context, "Registered Successfully!", Toast.LENGTH_SHORT).show()
                            isRegistering = false
                        } else {
                            Toast.makeText(context, "Username already exists", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    userViewModel.login(username, password) { success ->
                        if (success) {
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                            onLoginSuccess()
                        } else {
                            Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)

        ) {
            Text(text = if (isRegistering) "Register" else "Login", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { isRegistering = !isRegistering }) {
            Text(
                text = if (isRegistering) "Already have an account? Login" else "No account? Register",
                color = Color.White
            )
        }
    }
}

