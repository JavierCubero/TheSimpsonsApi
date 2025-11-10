package edu.iesam.thesimpsonsapi.features.simpsons.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAllCharactersUseCaseTest {
    @Test
    fun `when repository return success then usecase return success`() = runTest {
        val simpsonRepositoryMockk = mockk<SimpsonRepository>()
        val expectedCharacters = listOf(
            Character(1, "name1", "age1", "", "", "ouch", "url1"),
            Character(2, "name2", "age2", "occupation2", "status", "phrase2", "url2"),
            Character(3, "name3", "age3", "occupation3", "status3", "phrase3", "url3"),
        )
        coEvery { simpsonRepositoryMockk.findAll(1) } returns Result.success(expectedCharacters)
        val getCharactersUseCase = GetAllCharactersUseCase(simpsonRepositoryMockk, 1)

        val result = getCharactersUseCase()
        assert(result.isSuccess)
        assertEquals(result, Result.success(expectedCharacters))
        coVerify (exactly = 1) { simpsonRepositoryMockk.findAll(1)}
    }
}