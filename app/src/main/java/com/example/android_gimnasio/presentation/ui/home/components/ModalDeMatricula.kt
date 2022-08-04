package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.android_gimnasio.R
import com.example.android_gimnasio.presentation.ui.welcome.components.ModalDeError
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun ModalDeMatricula(
    onClickMatriculaExitosa: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        backgroundColor = Color.DarkGray,
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            Column {
                Button(onClick = onClickMatriculaExitosa,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.icon_tarjeta_credito),
                            contentDescription = "Tarjeta de Credito"
                        )
                        Text(stringResource(id = R.string.pay_by_credit_card), fontSize = 10.sp)
                    }
                )
                Button(
                    onClick = onClickMatriculaExitosa,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.tarjeta_de_debito_automatic),
                            contentDescription = stringResource(R.string.debit_automatic)
                        )
                        Text(stringResource(id = R.string.debit_automatic), fontSize = 10.sp)
                    }
                )
                Button(
                    onClick = onClickMatriculaExitosa,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.icon_paypal),
                            contentDescription = "Icono de paypal"
                        )
                        Text(stringResource(id = R.string.pay_with_paypal), fontSize = 10.sp)
                    }
                )
            }
        },
        title = {
            Text(
                stringResource(id = R.string.tipos_de_pagos),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2,
                color = Color.White
            )
        },
        text = {
            Text(
                stringResource(id = R.string.seleccione_tipo_de_pago),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        },
        properties = DialogProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true,
        )
    )
}


@Preview(showBackground = true)
@Composable
fun MatricularsePreview() {
    AndroidgimnasioTheme {
        val muta = remember { mutableStateOf(false) }
        ModalDeMatricula(
            onClickMatriculaExitosa = {},
            onDismissRequest = {}
        )
    }
}
