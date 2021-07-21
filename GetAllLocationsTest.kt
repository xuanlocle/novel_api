
import android.location.Location
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


class GetAllLocationsTest {
    private lateinit var getAllLocations: GetAllLocations

    @Before
    fun setUp() {
        getAllLocations = GetAllLocations()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getLocationsRepository_returnNotNull() {
        assertThat(getAllLocations.locationsRepository).isNotNull()
    }

    @Test
    fun locationsRepository_getAllLocationsWithPageNull_returnNotNull() {
        val result = getAllLocations.locationsRepository.getAllLocations(null)
        assertThat(result).isNotNull()
        assertThat(result).isEmpty()
    }

    @Test
    fun locationsRepository_getAllLocationsWithPageNegative_returnNotNull() {
        val result = getAllLocations.locationsRepository.getAllLocations(-1)
        assertThat(result).isNotNull()
        assertThat(result).isEmpty()
    }

    @Test
    fun locationsRepository_getAllLocationsWithPagePositive_returnNotNull() {
        val result = getAllLocations.locationsRepository.getAllLocations(1)
        assertThat(result).isNotNull()
    }

    @Test
    fun invokeTest_Once_returnNotEmpty() {
        runBlocking {
            val listLocation =  mutableListOf<Location>()
            assertThat(listLocation).isEmpty()
            listLocation.addAll(getAllLocations.invoke(null))
            assertThat(listLocation).isNotEmpty()
        }
    }
    @Test
    fun invokeTest_Negative_returnNotNull() {
        runBlocking {
            val listLocation =  mutableListOf<Location>()
            listLocation.addAll(getAllLocations.invoke(-1))
            assertThat(listLocation).isEmpty()
        }
    }
}
