package com.abtingramian.service.data.api;

import com.abtingramian.service.common.util.ResourceProvider;
import com.abtingramian.service.data.model.Character;
import com.abtingramian.service.data.model.CharactersResponse;
import com.abtingramian.service.data.model.Episode;
import com.abtingramian.service.data.model.EpisodesResponse;
import com.google.common.base.Objects;
import com.google.gson.Gson;
import okhttp3.Credentials;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;

import static org.junit.Assert.assertTrue;

public class RickAndMortyApiTest extends BaseApiTest {

    private static RickAndMortyApi rickAndMortyApi;
    private static String apiCredentials;
    private ResourceProvider resourceProvider = new ResourceProvider(new Gson());

    @BeforeClass
    public static void setupSuite() throws Exception {
        rickAndMortyApi = getRetrofitBuilder()
                .baseUrl(config.rickAndMortyApiBaseUrl)
                .build()
                .create(RickAndMortyApi.class);
        apiCredentials = Credentials.basic("rickAndMortyApi", config.apiKey);
    }

    @Test
    public void test_get_characters() throws Exception {
        final Response<CharactersResponse> response = rickAndMortyApi.getCharacters(null)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(!response.body().characters.isEmpty());
    }

    @Test
    public void test_get_character() throws Exception {
        final Response<Character> response = rickAndMortyApi.getCharacter(1)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(Objects.equal(response.body().id, 1));
    }

    @Test
    public void test_get_episodes() throws Exception {
        final Response<EpisodesResponse> response = rickAndMortyApi.getEpisodes(null)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(!response.body().episodes.isEmpty());
    }

    @Test
    public void test_get_episode() throws Exception {
        final Response<Episode> response = rickAndMortyApi.getEpisode(1)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(Objects.equal(response.body().id, 1));
    }

    /*
    @Test
    public void test_send_email() throws Exception {
        final Response<Void> response = rickAndMortyApi.multipart(apiCredentials,
                "Test <noreply@test.com>",
                "test@test.com",
                "Test",
                "message",
                "message html",
                true)
                .execute();
        assertTrue(response.isSuccessful());
    }
    */

}
