package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDetails
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionUiState
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.poppinFont

@Composable
fun AddictionsScreen(
    modifier: Modifier,
    addictionUiState: State<AddictionUiState>,
    onClick: () -> Unit,
    onAddAddictionClick: () -> Unit,
    onAddAddiction: (AddictionDetails) -> Unit,
    addictionList: List<Addiction>,
    ) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        topBarTitle("Pause Refléxion", 36.sp)
        Spacer(Modifier.size(40.dp))
        LazyColumn(modifier = modifier) {
            items(
                items = addictionList,
                key = { task: Addiction -> task.id}
            ) { task ->
                Button(
                    onClick = onClick,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = PrimaryWhite,
                        containerColor = Color(0xFF4CA77D)
                    )
                ) {
                    Text(
                        text = task.name,
                        fontSize = 20.sp,
                        fontFamily = poppinFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    )
                }
            }
        }


        Button(
            onClick = onAddAddictionClick,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = PrimaryWhite,
                containerColor = Color(0xFF4CA77D)
            )
        ) {
            Text(
                text = "Ajouter une addiction",
                fontSize = 20.sp,
                fontFamily = poppinFont,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        if (addictionUiState.value.showDialog) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text(text = "Nouvelle Addiction") },
                text = {
                    TextField(
                        value = addictionUiState.value.addictionDetails.addiction,
                        onValueChange = { onAddAddiction(addictionUiState.value.addictionDetails.copy(addiction = it)) },
                        label = { Text("Nom de l'addiction") }
                    )
                },
                confirmButton = {
                    Button(onClick = onClick) {
                        Text("Ajouter")
                    }
                },
                dismissButton = {
                    Button(onClick = { /*showDialog = false*/ }) {
                        Text("Annuler")
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnBoardingScreenPreview(){
    //OnBoardingScreen("J'ai envie de boire une monster", onClick = {}, onAddAddiction = {})
}