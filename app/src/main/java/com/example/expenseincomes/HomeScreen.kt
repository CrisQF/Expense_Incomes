package com.example.expenseincomes

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.expenseincomes.ui.theme.Zinc


@Composable
fun HomeScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow, list, card, topBar) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.rectangle_9),
                contentDescription = null,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(nameRow) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
            Column {
                Text(text = "Buenos días", fontSize =16.sp, color = Color.White)
                Text(
                    text = "Isiliano",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    )
            }
            Image(
                painter = painterResource(id = R.drawable.campanita),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
            }
            CardItem(modifier = Modifier
                .constrainAs(card) {
                    top.linkTo(nameRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            TransactionList(modifier = Modifier.fillMaxWidth().constrainAs(list) {
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            })


        }
    }
}

@Composable
fun CardItem(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Zinc)
            .padding(16.dp)

    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            ){
            Column (modifier = Modifier.align(Alignment.CenterStart)) {
                Text(text = " Saldo Total", fontSize = 16.sp, color = Color.White)
                Text(
                    text = "S/ 5000",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable._points),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        Box(
            modifier= Modifier
                .fillMaxWidth()
                .weight(1f),
            ) {
            CardRowItem(
                modifier = Modifier.align(Alignment.CenterStart),
                title = "Ingresos", amount = "S/ 90",
                image= R.drawable.ingresos
            )
            CardRowItem(
                modifier = Modifier.align(Alignment.CenterEnd),
                title = "Gastos",
                amount = "S/ 1000",
                image = R.drawable.gastos
            )

        }
        }

    }

@Composable
fun TransactionList(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Operaciones recientes", fontSize = 20.sp)
            Text(
                text = "Ver todo",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        TransactionItem(
            title = "Netflix",
            amount = "-S/ 80",
            icon = R.drawable.ic_launcher_foreground,
            date = "Today",
            color = Color.Red
        )
        TransactionItem(
            title = "Julio Mécanico",
            amount = "+S/ 80",
            icon = R.drawable.ic_launcher_foreground,
            date = "Today",
            color = Color.Red
        )
        TransactionItem(
            title = "Mercado",
            amount = "-S/ 80",
            icon = R.drawable.ic_launcher_foreground,
            date = "Today",
            color = Color.Red
        )
        TransactionItem(
            title = "Pensión ISIL",
            amount = "-S/ 80",
            icon = R.drawable.ic_launcher_foreground,
            date = "Today",
            color = Color.Red
        )
    }

}

@Composable
fun CardRowItem(modifier: Modifier, title: String, amount: String, image: Int) {
    Column (modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = title, fontSize = 16.sp, color = Color.White)
        }
        Text(text = amount, fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun TransactionItem(title: String, amount: String, icon: Int, date: String, color: Color) {
    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp )) {
        Row {
            Image(
                painter = painterResource(id=icon), contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = title, fontSize = 16.sp)
                Text(text = date, fontSize = 12.sp)
            }
        }
        Text(
            text = amount,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterEnd),
            color = color
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen()
}



