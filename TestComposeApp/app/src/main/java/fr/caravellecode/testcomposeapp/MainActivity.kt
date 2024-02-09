package fr.caravellecode.testcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.caravellecode.testcomposeapp.ui.theme.TestComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BlendModeRunThru()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BlendModeRunThru(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Text(
            text = "BlendMode Demo",
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center,
            style = TextStyle.Default.copy(
                fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold
            )
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            for (mode: BlendMode in listOf(
                BlendMode.Clear,
                BlendMode.Src,
                BlendMode.Dst,
                BlendMode.SrcOver,
                BlendMode.DstOver,
                BlendMode.SrcIn,
                BlendMode.DstIn,
                BlendMode.SrcOut,
                BlendMode.DstOut,
                BlendMode.SrcAtop,
                BlendMode.DstAtop,
                BlendMode.Xor,
                BlendMode.Plus,
                BlendMode.Modulate,
                BlendMode.Screen,
                BlendMode.Overlay,
                BlendMode.Darken,
                BlendMode.Lighten,
                BlendMode.ColorDodge,
                BlendMode.ColorBurn,
                BlendMode.Hardlight,
                BlendMode.Softlight,
                BlendMode.Difference,
                BlendMode.Exclusion,
                BlendMode.Multiply,
                BlendMode.Hue,
                BlendMode.Saturation,
                BlendMode.Color,
                BlendMode.Luminosity,
            )) {
                ImageWithTintAndBlendModeColorFilter(
                    blendMode = mode,
                    tintValue = tint(blendMode = mode, color = Color.Green)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ImageColorFilterBlendMode() {
    TestComposeAppTheme {
        BlendModeRunThru()
    }
}

@Composable
fun ImageWithTintAndBlendModeColorFilter(tintValue: ColorFilter, blendMode: BlendMode) {
    Box(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .border(Dp.Hairline, color = Color.Black)
            .padding(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = blendMode.toString(),
                textAlign = TextAlign.End,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.mipmap.ic_white_nosed_coati_foreground),
                contentDescription = "White nosed coati PNG image with transparent background",
                contentScale = ContentScale.Inside,
                colorFilter = tintValue,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}