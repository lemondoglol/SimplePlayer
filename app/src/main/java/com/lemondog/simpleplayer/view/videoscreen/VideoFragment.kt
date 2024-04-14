package com.lemondog.simpleplayer.view.videoscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.lemondog.simpleplayer.view.CustomBottomNavigationItemView
import com.lemondog.simpleplayer.view.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment() {

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
                            videoPageSelected = true,
                            onMusicButtonAction = {
                                val action = VideoFragmentDirections.actionVideoFragmentToHomeFragment()
                                findNavController().navigate(action)
                            },
                        )
                    },
                ) {
                    Text("Video Screen")
                }
            }
        }
    }
}
