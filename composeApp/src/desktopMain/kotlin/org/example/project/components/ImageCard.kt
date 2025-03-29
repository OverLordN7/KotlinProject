package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageCard(imagePath: String = "", description: String = ""){
    Image(
        painter = painterResource(Res.drawable.compose_multiplatform),
        contentDescription = description,
        modifier = Modifier.size(200.dp)
    )
}