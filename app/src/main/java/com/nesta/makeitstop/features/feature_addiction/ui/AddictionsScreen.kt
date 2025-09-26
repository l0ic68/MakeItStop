package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.background
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
    addictionUiState: State<AddictionUiState>,
    onClick: () -> Unit,
    onAddAddictionClick: () -> Unit,
    onAddAddiction: (AddictionDetails) -> Unit,
    addictionList: List<Addiction>,
    modifier: Modifier = Modifier,
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to Color(0xFF0E1B4A),
                    0.6f to Color(0xFF1B2B6A),
                    1f to Color(0xFF2B2F73)
                )
            ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Pause refléxion",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF)
            )
            Spacer(Modifier.size(40.dp))
            LazyColumn(modifier = modifier) {
                items(
                    items = addictionList,
                    key = { task: Addiction -> task.id }
                ) { task ->
                    Button(
                        onClick = onClick,
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
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
                    containerColor = Color(0xFFA89CE3)
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
                    containerColor = Color.Transparent,
                    
                    modifier = Modifier.background(
                        Brush.verticalGradient(
                            0f to Color(0xFF0E1B4A),
                            0.6f to Color(0xFF1B2B6A),
                            1f to Color(0xFF2B2F73)
                        )
                    ),
                    onDismissRequest = { },
                    title = {
                        Text(
                            text = "Nouvelle Addiction",
                            color = Color.White
                        )
                    },
                    text = {
                        TextField(
                            value = addictionUiState.value.addictionDetails.addiction,
                            onValueChange = {
                                onAddAddiction(
                                    addictionUiState.value.addictionDetails.copy(
                                        addiction = it
                                    )
                                )
                            },
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
}

@Composable
@Preview(showBackground = true)
fun OnBoardingScreenPreview() {
    val fakeState = remember { mutableStateOf(AddictionUiState(showDialog = false)) }

    // fake list
    val fakeList = listOf(
        Addiction(id = 1, name = "Monster Energy"),
        Addiction(id = 2, name = "Café")
    )
    AddictionsScreen(
        modifier = Modifier,
        addictionUiState = fakeState,
        onClick = {},
        onAddAddictionClick = {},
        onAddAddiction = {},
        addictionList = fakeList
    )
}