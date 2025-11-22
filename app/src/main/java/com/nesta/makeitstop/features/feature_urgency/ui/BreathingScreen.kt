@file:Suppress("unused")

package com.nesta.makeitstop.features.feature_urgency.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.utils.KeepScreenOn
import kotlinx.coroutines.delay
import kotlinx.coroutines.time.delay


enum class Phase {
    Idle,
    Inhale,
    Exhale,
    Hold,
    Done
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreathingScreen(
    title:String = stringResource(R.string.urgency_breathing_title),
    totalCycles: Int = 5,
    inhaleSeconds: Int = 4,
    exhaleSeconds: Int = 6,
    holdSeconds: Int = 0,
    circleSize: Dp = 280.dp
) {
    KeepScreenOn()
    var phase by remember { mutableStateOf(Phase.Idle) }
    var cycle by remember { mutableIntStateOf(0) }
    var secondLeft by remember { mutableIntStateOf(inhaleSeconds) }
    var running by remember { mutableStateOf(false) }

    val targetScale = when (phase) {
        Phase.Inhale -> 1.12f
        Phase.Hold -> 1.12f
        Phase.Exhale -> 0.96f
        else -> 1f
    }

    val phaseDuration = when (phase) {
        Phase.Inhale -> inhaleSeconds
        Phase.Hold -> holdSeconds
        Phase.Exhale -> exhaleSeconds
        else -> 0
    }


    val scale by animateFloatAsState(
        targetValue = targetScale,
        animationSpec = when (phase) {
            Phase.Inhale -> tween(phaseDuration * 1000, easing = FastOutSlowInEasing)
            Phase.Hold -> tween(phaseDuration * 1000, easing = FastOutSlowInEasing) // en pratique pas utile, la valeur reste constante
            else -> tween(phaseDuration * 1000, easing = LinearEasing)
        },
        label = "breathScale"
    )

    LaunchedEffect(running, cycle, phase) {
        if (!running) return@LaunchedEffect

        when (phase) {
            Phase.Inhale -> {
                secondLeft = inhaleSeconds
                while (secondLeft > 0 && running) {
                    delay(1000); secondLeft--
                }
                if (!running) return@LaunchedEffect
                if (holdSeconds != 0)
                    phase = Phase.Hold
                else
                    phase = Phase.Exhale
            }
            Phase.Hold -> {
                secondLeft = holdSeconds
                while (secondLeft > 0 && running) {
                    delay(1000); secondLeft--
                }
                if (!running) return@LaunchedEffect
                phase = Phase.Exhale
            }

            Phase.Exhale -> {
                secondLeft = exhaleSeconds
                while (secondLeft > 0 && running) {
                    delay(1000); secondLeft--
                }
                if (!running) return@LaunchedEffect
                val next = cycle + 1
                if (next >= totalCycles) {
                    phase = Phase.Done
                    running = false
                } else {
                    cycle = next
                    phase = Phase.Inhale
                }
            }

            Phase.Idle, Phase.Done -> Unit
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE6ECFF),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(28.dp))

        Box(
            modifier = Modifier
                .size(circleSize)
                .scale(scale),
            contentAlignment = Alignment.Center
        ) {
            BreathingRing(
                modifier = Modifier.fillMaxSize(),
                progress = when (phase) {
                    Phase.Inhale -> 1f - (secondLeft / inhaleSeconds.toFloat()
                        .coerceAtLeast(1f))
                    Phase.Exhale -> 1f - (secondLeft / exhaleSeconds.toFloat()
                        .coerceAtLeast(1f))
                    Phase.Hold -> 1f - (secondLeft / holdSeconds.toFloat()
                        .coerceAtLeast(1f))

                    else -> 0f
                }
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    when (phase) {
                        Phase.Exhale -> stringResource(R.string.urgency_breathing_exhale)
                        Phase.Inhale -> stringResource(R.string.urgency_breathing_inhale)
                        Phase.Hold -> stringResource(R.string.urgency_breathing_hold)
                        Phase.Done -> stringResource(R.string.urgency_breathing_done)
                        Phase.Idle -> stringResource(R.string.urgency_breathing_inhale)
                    },
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFE6ECFF)
                )
                Spacer(Modifier.height(8.dp))
                val current = if (phase == Phase.Done) totalCycles else cycle
                val progress = stringResource(
                    id = R.string.urgency_breathing_cycles_progress,
                    current,
                    totalCycles
                )

                Text(
                    text = if (phase == Phase.Done || !running) "${inhaleSeconds}s"
                    else "${maxOf(0,secondLeft)}s",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE6ECFF)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    //TODO LOU Expirer x Secodnes / Hold x secondes / Etc...
                    text = stringResource(
                        id = R.string.urgency_breathing_exhale_mouth,
                        exhaleSeconds,
                    ),
                    lineHeight = 18.sp,
                    fontSize = 16.sp,
                    color = Color(0xFFE6ECFF),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(Modifier.height(32.dp))

        Button(
            onClick = {
                if (running) {
                    running = false
                    phase = Phase.Idle
                    cycle = 0
                    secondLeft = inhaleSeconds
                } else {
                    running = true
                    phase = Phase.Inhale
                    cycle = 0
                    secondLeft = inhaleSeconds
                }
            },
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7C89D9),
                contentColor = Color(0xFF0E1330)
            ),
            modifier = Modifier
                .widthIn(min = 220.dp)
                .height(56.dp)
        ) {
            val currentText =
                if (phase == Phase.Done)
                    stringResource(R.string.urgency_breathing_stop)
                else
                    stringResource(R.string.urgency_breathing_start)

            Text(
                text = currentText,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(Modifier.height(18.dp))
        val current = if (phase == Phase.Done) totalCycles else cycle
        val progress = stringResource(
            id = R.string.urgency_breathing_cycles_progress,
            current,
            totalCycles
        )
        Text(
            progress,
            fontSize = 16.sp,
            color = Color(0xFFADB6E6)
        )
    }
}

@Composable
private fun BreathingRing(
    modifier: Modifier,
    progress: Float,
    borderColor: Color = Color(0xFF9FA8E8),
    trackColor: Color = Color(0x334652A8),
    strokeWidth: Dp = 6.dp
) {
    Canvas(modifier = modifier) {
        val stroke = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        val radius = size.minDimension / 2f - stroke.width / 2f
        val center = Offset(size.width / 2f, size.height / 2f)

        drawCircle(color = trackColor, radius = radius, center = center, style = stroke)

        drawArc(
            color = borderColor,
            startAngle = -90f,
            sweepAngle = 360f * progress,
            useCenter = false,
            style = stroke,
            size = size
        )
    }
}


@Preview
@Composable
fun BreathingScreenPreview() {
    PreviewBackground {
        BreathingScreen(
            totalCycles = 8,
            inhaleSeconds = 4,
            exhaleSeconds = 6
        )
    }
}
