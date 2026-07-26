package com.danilobarreto.stockapp.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import com.danilobarreto.stockapp.designsystem.theme.StockAppTypography

@Composable
fun StockAppAvatar(
    imageUrl: String?,
    fallbackText: String,
    fallbackBackgroundColor: Color,
    fallbackTextColor: Color,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(fallbackBackgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        if (imageUrl != null) {
            SubcomposeAsyncImage(
                model = imageUrl,
                contentDescription = fallbackText,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(size),
            ) {
                val state by painter.state.collectAsState()
                if (state is AsyncImagePainter.State.Error) {
                    AvatarFallbackText(fallbackText, fallbackTextColor)
                } else {
                    SubcomposeAsyncImageContent()
                }
            }
        } else {
            AvatarFallbackText(fallbackText, fallbackTextColor)
        }
    }
}

@Composable
private fun AvatarFallbackText(text: String, textColor: Color) {
    Text(text = text, style = StockAppTypography.labelSmall, color = textColor, maxLines = 1)
}