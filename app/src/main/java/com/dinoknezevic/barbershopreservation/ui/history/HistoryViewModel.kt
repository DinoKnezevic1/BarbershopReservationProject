package com.dinoknezevic.barbershopreservation.ui.history

import androidx.lifecycle.ViewModel
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.ui.history.mapper.HistoryScreenMapper
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper


class HistoryViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val historyMapper: HistoryScreenMapper,
) : ViewModel() {
    /*
    val favoritesViewState: StateFlow<FavoritesViewState> =
        movieRepository.favoriteMovies()
            .map(favoritesMapper::toFavoritesViewState)
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                FavoritesViewState(listOf())
            )

    fun toggleFavorite(movieId: Int) {
        viewModelScope.launch {
            movieRepository.toggleFavorite(movieId)
        }
    }
    */
}
