package com.dinoknezevic.barbershopreservation.ui.reservation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoknezevic.barbershopreservation.data.repository.BarbershopRepository
import com.dinoknezevic.barbershopreservation.ui.reservation.mapper.ReservationsScreenMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReservationViewModel(
    private val barbershopRepository: BarbershopRepository,
    private val reservationMapper: ReservationsScreenMapper,
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
