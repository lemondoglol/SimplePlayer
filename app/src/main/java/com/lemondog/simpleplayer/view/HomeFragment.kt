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
import androidx.navigation.findNavController
import com.lemondog.simpleplayer.R
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
                    Text("Home")
                }
            }
        }
    }
}