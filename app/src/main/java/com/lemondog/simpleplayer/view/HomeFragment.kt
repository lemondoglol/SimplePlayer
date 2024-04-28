package com.lemondog.simpleplayer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

/**
 * ToDos:
 * 1. setup youtube with simple data
 * 2. test setup music view
 * 3. test setup video view
 * 4. setup Repository
 * 5. setup RoomDB
 * */
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
                                val action = HomeFragmentDirections.actionHomeFragmentToVideoFragment()
                                findNavController().navigate(action)
                            },
                        )
                    },
                ) {
                    YoutubePlayerContainer(
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }

    @Composable
    private fun YoutubePlayerContainer(
        modifier: Modifier = Modifier,
    ) {
        AndroidView(
            modifier = modifier,
            factory = {
                viewModel.youtubePlayerView
            }
        )
    }
}