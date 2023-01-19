package com.dinoknezevic.barbershopreservation.ui.finish.di

import com.dinoknezevic.barbershopreservation.ui.finish.FinishViewModel
import com.dinoknezevic.barbershopreservation.ui.finish.mapper.FinishScreenMapper
import com.dinoknezevic.barbershopreservation.ui.finish.mapper.FinishScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val finishModule = module {
    viewModel {
        (serviceId:Int,pickedDate:Long)->
        FinishViewModel(
            barbershopRepository = get(),
            finishScreenMapper = get(),
            serviceId = serviceId,
            pickedDate = pickedDate,
        )
    }
    single <FinishScreenMapper>{FinishScreenMapperImpl()}
}