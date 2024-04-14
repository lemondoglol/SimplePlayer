package com.lemondog.simpleplayer.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lemondog.simpleplayer.R

@Composable
fun CustomBottomNavigationItemView(
    modifier: Modifier = Modifier,
    musicPageSelected: Boolean = false,
    videoPageSelected: Boolean = false,
    onMusicButtonAction: () -> Unit = {},
    onVideoButtonAction: () -> Unit = {},
) {
    BottomNavigation(modifier = modifier) {
        BottomNavigationItem(
            selected = musicPageSelected,
            onClick = { onMusicButtonAction() },
            icon = {
                Text(stringResource(R.string.music))
            },
        )
        BottomNavigationItem(
            selected = videoPageSelected,
            onClick = { onVideoButtonAction() },
            icon = {
                Text(stringResource(R.string.video))
            },
        )
    }
}