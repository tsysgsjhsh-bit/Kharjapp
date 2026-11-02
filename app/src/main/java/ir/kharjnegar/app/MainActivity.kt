package ir.kharjnegar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Teal = Color(0xFF087F75)
private val Background = Color(0xFFF4F8F7)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                text = "خرج‌نگار",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Teal
            )
            Text(
                text = "مدیریت ساده دخل‌وخرج",
                fontSize = 15.sp,
                color = Color.DarkGray
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Teal)
            ) {
                Column(modifier = Modifier.padding(22.dp)) {
                    Text("موجودی کل", color = Color.White.copy(alpha = 0.85f))
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "۰ تومان",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "نمای کلی وضعیت مالی شما",
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SummaryCard("درآمد", "۰ تومان", Modifier.weight(1f))
                SummaryCard("هزینه", "۰ تومان", Modifier.weight(1f))
            }
            Spacer(Modifier.height(4.dp))
            Text(
                "تراکنش‌های اخیر",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("هنوز تراکنشی ثبت نشده است", color = Color.Gray)
                }
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Teal)
            ) {
                Text("ثبت اولین تراکنش", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun SummaryCard(title: String, amount: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(title, color = Color.Gray)
            Text(
                amount,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Teal
            )
        }
    }
}
