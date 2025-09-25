package com.nesta.makeitstop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nesta.makeitstop.navigation.Module
import com.nesta.makeitstop.ui.theme.titleColor


/**
 * enum values that represent the screens in the app
 */
enum class MakeItStopScreen() {
    DashBoard,
    Addiction
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeItStopApp(
    onModuleClick: (Module) -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier.background(
            Brush.verticalGradient(
                0f to Color(0xFF0E1B4A),
                0.6f to Color(0xFF1B2B6A),
                1f to Color(0xFF2B2F73)
            )
        ),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "MakeItStop",
                        fontSize = 30.sp
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            Spacer(Modifier.height(8.dp))
            MakeItStopScreenContent(
                onModuleClick = onModuleClick,
                Modifier
                     .fillMaxWidth()
                    .fillMaxHeight()

            )
        }


    }
}
@Composable
fun MakeItStopScreenContent(
    onModuleClick: (Module) -> Unit,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            horizontal = 6.dp,
            vertical = 0.dp
        ),

        modifier = modifier.padding(
            bottom = 6.dp
        )
    ) {
        item {
            ModuleCard(
                modifier = Modifier,
                text = "Addiction",
                onClick = { onModuleClick(Module.Addiction)}
            )
        }
        item {
            ModuleCard(
                modifier = Modifier,
                text = "Sleeping",
                onClick = { onModuleClick(Module.Sleep)}
            )
        }
        item {
            ModuleCard(
                modifier = Modifier,
                text = "Urgency",
                onClick = { onModuleClick(Module.Urgency)}
            )
        }

    }
}

@Composable
fun ModuleCard(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(6.dp)
            .aspectRatio(1f)
            .clickable(
                enabled = true,
                onClick = onClick,
                role = Role.Button
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

        ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.dormir),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp),
                contentDescription = ""
            )
            Text(
                text = text,
            )

        }
    }
}