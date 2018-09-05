package com.abtingramian.service.data.api;

import com.abtingramian.service.common.util.ResourceProvider;
import com.google.common.base.Objects;
import com.google.gson.Gson;
import okhttp3.Credentials;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;

import static org.junit.Assert.assertTrue;

public class ExampleApiTest extends BaseApiTest {

    private static ExampleApi exampleApi;
    private static String apiCredentials;
    private ResourceProvider resourceProvider = new ResourceProvider(new Gson());
/*
    @BeforeClass
    public static void setupSuite() throws Exception {
        exampleApi = getRetrofitBuilder()
                .baseUrl(config.rickAndMortyApiBaseUrl)
                .build()
                .create(ExampleApi.class);
        apiCredentials = Credentials.basic("exampleApi", config.apiKey);
    }

    @Test
    public void test_get_characters() throws Exception {
        final Response<CharactersResponse> response = exampleApi.getCharacters(null)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(!response.body().characters.isEmpty());
    }

    @Test
    public void test_get_character() throws Exception {
        final Response<Character> response = exampleApi.getCharacter(1)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(Objects.equal(response.body().id, 1));
    }

    @Test
    public void test_get_episodes() throws Exception {
        final Response<EpisodesResponse> response = exampleApi.getEpisodes(null)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(!response.body().episodes.isEmpty());
    }

    @Test
    public void test_get_episode() throws Exception {
        final Response<Episode> response = exampleApi.getEpisode(1)
                .execute();
        assertTrue(response.isSuccessful());
        assertTrue(Objects.equal(response.body().id, 1));
    }

    @Test
    public void test_send_email() throws Exception {
        final Response<Void> response = exampleApi.multipart(apiCredentials,
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
