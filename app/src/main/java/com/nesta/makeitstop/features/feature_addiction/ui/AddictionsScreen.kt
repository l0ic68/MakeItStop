package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nesta.makeitstop.R
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDetails
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionUiState
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.nunitoFont
import com.nesta.makeitstop.ui.theme.poppinFont

@Composable
fun AddictionsScreen(
    addictionUiState: State<AddictionUiState>,
    onClick: () -> Unit,
    onAddAddictionClick: () -> Unit,
    onRemoveAddictionPopupClick: () -> Unit,
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
                    text = stringResource(R.string.add_addiction),
                    fontSize = 20.sp,
                    fontFamily = poppinFont,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            }
            if (addictionUiState.value.showDialog) {
                Dialog(
                    onDismissRequest = onRemoveAddictionPopupClick,
                    properties = DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true,
                        usePlatformDefaultWidth = false
                    )
                ) {
                    AddAddictionPopup(
                        onClick = onClick,
                        addictionUiState = addictionUiState,
                        onAddAddiction = onAddAddiction,
                        onRemoveAddictionPopupClick = onRemoveAddictionPopupClick
                    )
                }
            }
        }
    }
}

@Composable
fun AddAddictionPopup(
    onClick: () -> Unit,
    addictionUiState: State<AddictionUiState>,
    onAddAddiction: (AddictionDetails) -> Unit,
    onRemoveAddictionPopupClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9FB))
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.add_addiction),
                fontSize = 25.sp,
                fontFamily = nunitoFont,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1B1C42),
                textAlign = TextAlign.Center
            )
            OutlinedTextField(
                value = addictionUiState.value.addictionDetails.addiction,
                onValueChange = {
                    onAddAddiction(
                        addictionUiState.value.addictionDetails.copy(
                            addiction = it
                        )
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedPrefixColor = Color.Red,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,
                    focusedPlaceholderColor = Color.LightGray,
                    unfocusedPlaceholderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(12.dp),
                label = {
                    Text(
                        stringResource(R.string.add_addiction_name),
                    )
                }
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = onRemoveAddictionPopupClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(25.dp),
                ) {
                    Text(
                        text = stringResource(R.string.app_cancel),
                        color = Color.Black
                    )
                }
                Button(
                    onClick = onClick,
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFa89ce3),
                        contentColor = Color.White
                    )
                ) {
                    Text(stringResource(R.string.app_confirme))
                }
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
        onRemoveAddictionPopupClick = {},
        addictionList = fakeList
    )
}

@Composable
@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 200
)
fun AddAddictionPopupScreenPreview() {
    val fakeState = remember { mutableStateOf(AddictionUiState(showDialog = false)) }

    AddAddictionPopup(
        onClick = {},
        fakeState,
        { },
        onRemoveAddictionPopupClick = {}
    )
}