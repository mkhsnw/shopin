package com.example.qpon_clone.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EmailTextField(modifier: Modifier = Modifier,value : String, onValueChange : (String) -> Unit, isError : Boolean, onNext : (() -> Unit)? = null) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Email Address") },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
        singleLine = true,
        isError = isError,
        keyboardOptions = KeyboardOptions(
            imeAction = if(onNext != null) ImeAction.Next else ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNext?.invoke()
            })
    )
}

@Composable
fun PasswordTextField(modifier: Modifier = Modifier,value : String, onValueChange : (String) -> Unit, isError : Boolean, onDone : (() -> Unit)? = null) {
    var visible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        singleLine = true,
        leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
        visualTransformation = if(visible) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@Composable
fun FullnameTextfield(modifier: Modifier = Modifier,value : String, onValueChange : (String) -> Unit, isError : Boolean, onNext : (() -> Unit)? = null) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "Fullname") },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
    )
}