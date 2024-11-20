package com.apli.composeprimeraapp1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview
@Composable
fun ConstraintExample(){
    ConstraintLayout( modifier = Modifier.fillMaxSize()
        .background(Color.White)
    ) {


        //Declaración de las IDs para las referencias
        val(boxCenter,
            boxSideI,
            boxSideR,
            boxSideLowI,
            boxSideLowD,
            boxCenterUpper,
            boxSideLowI2,
            boxSideLowCenter,
            boxSideLowD2) = createRefs()


        //Elementos cajas organizadas
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxCenterUpper){
                bottom.linkTo(boxSideI.top)
                start.linkTo(boxSideI.end)

            }

        )



        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black)
            .constrainAs(boxCenter){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxSideI){
                bottom.linkTo(boxCenter.top)
                end.linkTo(boxCenter.start)
            }

        )


        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxSideR){
                bottom.linkTo(boxCenter.top)
                start.linkTo(boxCenter.end)
            }

        )


        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxSideLowI){
                top.linkTo(boxCenter.bottom)
                end.linkTo(boxCenter.start)
            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxSideLowD){
                top.linkTo(boxCenter.bottom)
                start.linkTo(boxCenter.end)
            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxCenterUpper){
                bottom.linkTo(boxSideI.top)
                start.linkTo(boxSideI.end)

            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxSideLowI2){
                top.linkTo(boxSideLowI.bottom)
                end.linkTo(boxSideLowI.start)

            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxSideLowCenter){
                top.linkTo(boxSideLowI.bottom)
                start.linkTo(boxSideLowI.end)

            }

        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(boxSideLowD2){
                top.linkTo(boxSideLowI.bottom)
                start.linkTo(boxSideLowD.end)

            }

        )


    }



}



