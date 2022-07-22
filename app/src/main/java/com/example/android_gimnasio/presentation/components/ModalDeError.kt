package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun ModalDeError(onConfirmButtonClick: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = onConfirmButtonClick, content = {
                Text("Aceptar")
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow))
        },
        title = {
            Text("Ocurrio un Error")
        },
        text = {
            Text("AUN NO SE REGISTRA")

        }
    )
}

@Preview(showBackground = true)
@Composable
fun IngresarAlTrenDialogPreview() {
    AndroidgimnasioTheme {
        val muta = remember { mutableStateOf(false) }
        ModalDeError({
        })
    }
}