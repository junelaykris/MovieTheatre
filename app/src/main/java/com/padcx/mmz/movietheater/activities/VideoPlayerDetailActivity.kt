package com.padcx.mmz.movietheater.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.VideoVO
import com.padcx.mmz.movietheater.mvp.presenters.VideoPresenter
import com.padcx.mmz.movietheater.mvp.presenters.VideoPresenterImpl
import com.padcx.mmz.movietheater.mvp.views.VideoView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.video_play_layout.*


/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */

class VideoPlayerDetailActivity : BaseActivity(), VideoView {
    private lateinit var mvdPresenter: VideoPresenter

    companion object {
        const val movieid = "Movie Id Extra"
        fun newIntents(context: Context, movieId: Int): Intent {
            val intent = Intent(context, VideoPlayerDetailActivity::class.java)
            intent.putExtra(movieid, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_play_layout)
        setUpPresenter()
        val mvId = intent.getIntExtra(MovieDetailActivity.movieid, 0)
        mvdPresenter.onUiReady(this, mvId)
    }

    private fun setUpPresenter() {
        mvdPresenter = ViewModelProviders.of(this).get(VideoPresenterImpl::class.java)
        mvdPresenter.initPresenter(this)
    }

    override fun displayVideo(list: List<VideoVO>) {
        lifecycle.addObserver(youtube_player_view)
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(list[0].key, 0f)
            }
        })
    }
}