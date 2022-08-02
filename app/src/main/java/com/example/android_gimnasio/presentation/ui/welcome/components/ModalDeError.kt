package com.example.android_gimnasio.presentation.ui.welcome.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import com.example.android_gimnasio.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun ModalDeError(onConfirmButtonClick: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = onConfirmButtonClick, content = {
                Text(stringResource(id = R.string.accept))
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow))
        },
        title = {
            Text(stringResource(id = R.string.an_error_ocurred))
        },
        text = {
            Text(stringResource(id = R.string.NOT_YET_REGISTERED))

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