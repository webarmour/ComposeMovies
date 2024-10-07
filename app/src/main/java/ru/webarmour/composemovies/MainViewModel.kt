package ru.webarmour.composemovies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.webarmour.composemovies.data.models.MovieDto
import ru.webarmour.composemovies.data.network.ApiRepository
import javax.inject.Inject

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository
): ViewModel() {

    private val _allMovies = MutableLiveData<List<MovieDto>>()
    val allMovies: LiveData<List<MovieDto>> = _allMovies

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getAllMovies().let {
                if (it.isSuccessful){
                    _allMovies.postValue(it.body())
                } else {
                    Log.d(TAG, "getAllMovies: failed to load data ${it.errorBody()}")
                }
            }
        }

    }

}