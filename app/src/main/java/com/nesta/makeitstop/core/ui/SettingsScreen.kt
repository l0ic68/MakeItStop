package com.nesta.makeitstop.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        TitleLarge(
            "Mes modules"
        )
        LazyColumn(
        ) {
            item {
                ComponentRow("Addictions")
            }
            item {
                ComponentRow("Sleep")
            }
            item {
                ComponentRow("Urgency")
            }
            item {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFF293a91)
                    )

                ) {
                    Text(
                        "+ Ajouter un module",
                        fontSize = 20.sp
                    )
                }
            }
        }


    }
}

@Composable
fun ComponentRow(
    text: String,
    isChecked: Boolean = true
) {
    var checked by remember { mutableStateOf(isChecked) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0XFFfefdff))
    ) {
        TextIcon(
            text = "menu",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(text)
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    PreviewBackground {
        SettingsScreen()
    }
}


@Preview
@Composable
fun ModulePreview() {
    ComponentRow("Module")
}