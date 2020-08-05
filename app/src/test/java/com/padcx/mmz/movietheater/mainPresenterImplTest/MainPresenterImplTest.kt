package com.padcx.mmz.movietheater.mainPresenterImplTest

import android.os.Build
import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.models.impls.MockMovieModelImpl
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.dummy.getDummyPopularMovieList
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenterImpl
import com.padcx.mmz.movietheater.mvp.views.HomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config
import java.util.ArrayList

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {
    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView: HomeView

    private lateinit var mMockMovieModel: MoviesModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MoviesModelImpls.initDatabase(ApplicationProvider.getApplicationContext())
        mMockMovieModel = MockMovieModelImpl

        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMoviesModel = this.mMockMovieModel
    }

    companion object {
        fun getMockLifeCycleOwner() : LifecycleOwner {
            val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
            val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
            lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
            Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
            return lifeCycleOwner
        }
    }

    @Test
    fun onTapMovie_callNavigateToPopularDetails() {
        val popularmovie = PopularMovieVO()
        val arr1 = ArrayList<Int>()
        arr1.add(35)
        arr1.add(10749)

        popularmovie.id = 1
        popularmovie.original_title = "The Kissing Booth 2"
        popularmovie.popularity = 120.0
        popularmovie.adult=false
        popularmovie.backdrop_path = "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg"
        popularmovie.original_language ="en"

        mPresenter.onTapDiscoverListItem(popularmovie)
        verify {
            mView.navigateToDetail( popularmovie.id)
        }
    }

    @Test
    fun onUIReady_callDisplayBurgerList_callDisplayCountInCart() {
        mPresenter.onUiReady(getMockLifeCycleOwner())
        verify {
            mView.displayPopularItems(getDummyPopularMovieList())
        }
    }

}
