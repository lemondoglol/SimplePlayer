package com.lemondog.simpleplayer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lemondog.simpleplayer.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    bottomBar = {
                        CustomBottomNavigationItemView(
                            musicPageSelected = true,
                            onVideoButtonAction = {
                            }
                        )
                    },
                ) {}
            }
        }
    }

    @Composable
    private fun CustomBottomNavigationItemView(
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
}