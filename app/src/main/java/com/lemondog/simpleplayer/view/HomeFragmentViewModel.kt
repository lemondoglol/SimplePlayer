package com.lemondog.simpleplayer.view

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lemondog.simpleplayer.di.MyApplicationContext
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    @MyApplicationContext applicationContext: Context,
) : ViewModel(), YouTubePlayerListener {

    val testingPlaylist = listOf("mG04SH2NCOQ", "whW29cbP-0U", "e-ORhEE9VVg")

    internal var currentPlayingItemIndex = mutableStateOf(0)
        private set

    internal val youtubePlayerView: YouTubePlayerView
    lateinit var youTubePlayer: YouTubePlayer

    init {
        youtubePlayerView =  YouTubePlayerView(context = applicationContext).apply {
            this.addYouTubePlayerListener(this@HomeFragmentViewModel)
            this.getYouTubePlayerWhenReady(object : YouTubePlayerCallback {
                override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                    testingPlaylist[currentPlayingItemIndex.value]?.let {
                        youTubePlayer.loadVideo(it, 0f)
                        youTubePlayer.play()
                    }
                    this@HomeFragmentViewModel.youTubePlayer = youTubePlayer
                }
            })
        }
    }

    // Listeners
    override fun onStateChange(youTubePlayer: YouTubePlayer, state: PlayerConstants.PlayerState) {
        when (state) {
            PlayerConstants.PlayerState.ENDED -> {
                currentPlayingItemIndex.value = currentPlayingItemIndex.value + 1
                testingPlaylist[currentPlayingItemIndex.value]?.let {
                    youTubePlayer.loadVideo(it, 0f)
                }
            }
            else -> Unit
        }
    }

    override fun onApiChange(youTubePlayer: YouTubePlayer) = Unit

    override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) = Unit

    override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) = Unit

    override fun onPlaybackQualityChange(
        youTubePlayer: YouTubePlayer,
        playbackQuality: PlayerConstants.PlaybackQuality
    ) = Unit

    override fun onPlaybackRateChange(
        youTubePlayer: YouTubePlayer,
        playbackRate: PlayerConstants.PlaybackRate
    ) = Unit

    override fun onReady(youTubePlayer: YouTubePlayer) = Unit

    override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) = Unit

    override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) = Unit

    override fun onVideoLoadedFraction(youTubePlayer: YouTubePlayer, loadedFraction: Float) = Unit

}
