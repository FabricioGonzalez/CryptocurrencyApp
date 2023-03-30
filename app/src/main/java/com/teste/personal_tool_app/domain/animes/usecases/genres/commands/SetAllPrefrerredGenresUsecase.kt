package com.teste.personal_tool_app.domain.animes.usecases.genres.commands

import com.teste.personal_tool_app.domain.animes.repositories.AnimeDatabaseRepository
import javax.inject.Inject

class SetAllPrefrerredGenresUsecase @Inject constructor(
    private val animeDatabase: AnimeDatabaseRepository
) {
    operator fun invoke() {

    }
}