package com.example.countercomposehanivia

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DataDiriScreen(
    modifier: Modifier = Modifier,
    viewModel: DataDiriViewModel = viewModel()
) {
    val nama by viewModel.nama
    val umur by viewModel.umur

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Form Data Diri",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Form Input Nama
        OutlinedTextField(
            value = nama,
            onValueChange = { viewModel.onNamaChange(it) },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        // Form Input Umur
        OutlinedTextField(
            value = umur,
            onValueChange = { viewModel.onUmurChange(it) },
            label = { Text("Umur") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ringkasan Hasil Inputan (Tampil jika nama atau umur sudah diisi)
        Text(
            text = "Nama saya \"$nama\" dan umur saya \"$umur\", Salam kenal!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}