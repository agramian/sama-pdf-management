package com.abtingramian.service.route;

import com.abtingramian.service.common.test.BaseRouteIntegrationTest;

public class FormRouteIntegrationTest extends BaseRouteIntegrationTest {
/*
    @Test
    public void test_character_patch_not_found() throws Exception {
        // trigger
        final TestResponse<BaseResponse> response = patch(Routes.FORM_GET, RequestBody.create(null, ""), BaseResponse.class);
        // verify
        assertEquals(404, response.response.code());
        assertFalse(response.response.isSuccessful());
        assertEquals(Errors.ERROR_404, response.responseModel);
    }

    @Test
    public void test_character_post_empty_body() throws Exception {
        // trigger
        final TestResponse<BaseResponse> response = post(Routes.CHARACTERS, RequestBody.create(null, ""), BaseResponse.class);
        // verify
        assertEquals(400, response.response.code());
        assertFalse(response.response.isSuccessful());
        assertEquals(Errors.ERROR_MISSING_POST_BODY, response.responseModel);
    }

    @Test
    public void test_user_email_post_email_success() throws Exception {
        // define
        final Character character = new Character();
        character.id = 1;
        character.name = "Test";
        // trigger
        final TestResponse<Character> response = post(Routes.CHARACTERS,
                RequestBody.create(MediaType.parse(com.google.common.net.MediaType.JSON_UTF_8.toString()),
                        gson.toJson(character)), Character.class);
        // verify
        assertEquals(201, response.response.code());
        assertTrue(response.response.isSuccessful());
        assertEquals(character, response.responseModel);
    }


    @Test
    public void test_user_email_post_email_success_professional() throws Exception {
        // define
        final User user = new User();
        user.email = "abtin.gramian@gmail.com";
        // trigger
        final TestResponse<User> response = post(Routes.USER_EMAIL,
                new ImmutableMap.Builder<String, String>().put("professional", "").build(),
                RequestBody.create(MediaType.parse(com.google.common.net.MediaType.JSON_UTF_8.toString()),
                        gson.toJson(user)), User.class);
        user.id = response.responseModel.id;
        // verify
        assertEquals(201, response.response.code());
        assertTrue(response.response.isSuccessful());
        assertEquals(user, response.responseModel);
    }
        @Test
    public void test_user_email_post_invalid_email() throws Exception {
        // define
        final User user = new User();
        user.email = "asdf";
        // trigger
        final TestResponse<BaseResponse> response = post(Routes.USER_EMAIL,
                RequestBody.create(MediaType.parse(com.google.common.net.MediaType.JSON_UTF_8.toString()),
                        gson.toJson(user)), BaseResponse.class);
        // verify
        assertEquals(400, response.response.code());
        assertFalse(response.response.isSuccessful());
        assertEquals(new BaseResponse.Builder().error(new Error("email", new Errors.InvalidPostBodyFieldException())).build(), response.responseModel);
    }

*/

}
