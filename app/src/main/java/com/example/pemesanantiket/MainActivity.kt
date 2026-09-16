package com.example.pemesanantiket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketBookingScreen()
        }
    }
}

@Composable
fun TicketBookingScreen() {
    var jumlahTiket by remember { mutableStateOf(1) }

    val hargaPerTiket = 25000
    val totalHarga = jumlahTiket * hargaPerTiket

    val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
    val totalHargaFormatted = formatRupiah.format(totalHarga)
        .replace(",00", "")
        .replace("Rp", "Rp")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FB))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E88E5))
                .padding(vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.ConfirmationNumber,
                contentDescription = "Ikon Tiket",
                tint = Color.White,
                modifier = Modifier
                    .size(48.dp)
                    .padding(bottom = 8.dp)
            )
            Text("Pemesanan Tiket", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Pesan tiket dengan mudah!", color = Color.White, fontSize = 14.sp)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Harga Tiket", fontWeight = FontWeight.Bold)
                    Text("Rp25.000", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E88E5))
                    Text("per tiket", color = Color.Gray)
                }
            }
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Jumlah Tiket", fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))

                    Button(
                        onClick = { if (jumlahTiket > 1) jumlahTiket-- },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
                    ) {
                        Text("-", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }

                    Text(
                        text = jumlahTiket.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Button(
                        onClick = { jumlahTiket++ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
                    ) {
                        Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Total", fontWeight = FontWeight.Bold)
                    Text(totalHargaFormatted, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E7B44))
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { jumlahTiket = 1 },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Ikon Reset",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("RESET", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}
