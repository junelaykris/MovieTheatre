package com.padcx.mmz.movietheater.mainPresenterImplTest

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.models.impls.MockMovieModelImpl
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.dummy.getDummyMovieDetail
import com.padcx.mmz.movietheater.dummy.getDummyPopularMovieList
import com.padcx.mmz.movietheater.mvp.presenters.DetailPresenter
import com.padcx.mmz.movietheater.mvp.presenters.DetailPresenterImpl
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenterImpl
import com.padcx.mmz.movietheater.mvp.views.HomeView
import com.padcx.mmz.movietheater.mvp.views.MovieDetailView
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
class DetailPresenterImplTest {
    private lateinit var mdetailPresenter: DetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MovieDetailView

    private lateinit var mMockMovieModel: MoviesModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MoviesModelImpls.initDatabase(ApplicationProvider.getApplicationContext())
        mMockMovieModel = MockMovieModelImpl

        mdetailPresenter = DetailPresenterImpl()
        mdetailPresenter.initPresenter(mView)
        mdetailPresenter.mMovieModel = this.mMockMovieModel
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
    fun onUIReady_callDisplayMovieDetail() {
        mdetailPresenter.onUiReady(getMockLifeCycleOwner(),1)
        verify {
            mView.displayMovieDetail(getDummyMovieDetail())
        }
    }

}