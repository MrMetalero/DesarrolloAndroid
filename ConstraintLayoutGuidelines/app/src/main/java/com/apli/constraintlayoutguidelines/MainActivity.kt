package com.apli.constraintlayoutguidelines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.apli.constraintlayoutguidelines.ui.theme.ConstraintLayoutGuidelinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutGuidelinesTheme {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BarrierExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()
        //val bTop = createTopBarrier(0.15f)
        val bBottom = createBottomBarrier(boxRed,boxBlue)
        //val bStart = createStartBarrier(0.25f)
        val bEnd = createEndBarrier(boxRed,boxBlue)
        Box(modifier = Modifier
            .size(150.dp)
            .background(Color.Red)
            .constrainAs(ref = boxRed){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                //bottom.linkTo(parent.bottom)
            }

        )
        Box(modifier = Modifier
            .size(190.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue){
                bottom.linkTo(boxRed.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                end.linkTo(boxBlue.start)
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxBlue.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta){
                start.linkTo(bEnd)
                top.linkTo(bBottom)
            })
    }
}




@Preview(showBackground = true)
@Composable
fun ConstraintExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()
        val glTop = createGuidelineFromTop(0.15f)
        val glBottom = createGuidelineFromBottom(300.dp)
        val glStart = createGuidelineFromStart(0.25f)
        val glEnd = createGuidelineFromEnd(0.15f)
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(ref = boxRed){
                top.linkTo(glTop)
                start.linkTo(glStart)
                end.linkTo(glEnd)
                bottom.linkTo(glBottom)
            }

        )
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue){
                bottom.linkTo(boxRed.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                end.linkTo(boxBlue.start)
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxBlue.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta){
                start.linkTo(boxRed.end)
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxRed.bottom)
            })
    }
}


@Preview(showBackground = true)
@Composable
fun ChainExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()
        val glTop = createGuidelineFromTop(0.15f)
        val glBottom = createGuidelineFromBottom(300.dp)
        val glStart = createGuidelineFromStart(0.25f)
        val glEnd = createGuidelineFromEnd(0.15f)
        val size = 100.dp
        Box(modifier = Modifier
            .size(size)
            .background(Color.Red)
            .constrainAs(ref = boxRed){
                top.linkTo(glTop)
                start.linkTo(glStart)
                end.linkTo(boxBlue.start)
                bottom.linkTo(glBottom)
            }

        )
        Box(modifier = Modifier
            .size(size)
            .background(Color.Blue)
            .constrainAs(boxBlue){
                bottom.linkTo(boxYellow.top)
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(size)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                end.linkTo(boxBlue.start)
                start.linkTo(boxBlue.end)
                bottom.linkTo(boxMagenta.top)
            })
        Box(modifier = Modifier
            .size(size)
            .background(Color.Magenta)
            .constrainAs(boxMagenta){
                start.linkTo(boxRed.end)
                top.linkTo(boxBlue.top)
                bottom.linkTo(boxRed.bottom)
            })
        createHorizontalChain(boxRed, boxBlue, boxYellow, boxMagenta)

    }
}
