package com.lemondog.simpleplayer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
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
                            homePageSelected = true,
                            onSummaryButtonAction = {
                            }
                        )
                    },
                ) {}
            }
        }
    }

    @Composable
    fun CustomBottomNavigationItemView(
        modifier: Modifier = Modifier,
        homePageSelected: Boolean = false,
        summaryPageSelected: Boolean = false,
        onHomeButtonAction: () -> Unit = {},
        onSummaryButtonAction: () -> Unit = {},
    ) {
        BottomNavigation(modifier = modifier) {
            BottomNavigationItem(
                selected = homePageSelected,
                onClick = { onHomeButtonAction() },
                icon = {
                       Text("Home")
//                    IconText(
//                        text = stringResource(R.string.home),
//                        imageVector = Icons.Filled.Home,
//                    )
                },
            )
            BottomNavigationItem(
                selected = summaryPageSelected,
                onClick = { onSummaryButtonAction() },
                icon = {
                    Text("Library")
//                    IconText(
//                        text = stringResource(R.string.summary),
//                        imageVector = Icons.Filled.Summarize,
//                    )
                },
            )
        }
    }
}