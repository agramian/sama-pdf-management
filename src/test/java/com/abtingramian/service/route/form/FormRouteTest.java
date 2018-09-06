package com.abtingramian.service.route.form;

public class FormRouteTest extends BaseFormRouteTest {
/*
    @Test
    public void test_create_character_empty_body() throws Exception {
        // mock
        when(request.body()).thenReturn("");
        // set expectations
        exception.expect(Errors.MissingPostBodyException.class);
        // trigger
        service.createCharacter(request, response);
    }

    @Test
    public void test_create_character_missing_id() throws Exception {
        // mock
        when(request.body()).thenReturn("{}");
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error(new Error("id", new Errors.MissingPostBodyFieldException())).build(),
                service.createCharacter(request, response));
    }

    @Test
    public void test_user_email_success() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        user.id = UUID.randomUUID();
        when(uuidProvider.randomUUID()).thenReturn(user.id);
        when(request.body()).thenReturn(gson.toJson(user));
        when(query.executeUpdate()).thenReturn(connection);
        when(exampleApi.multipart(any(), any(), any(), any(), any(), any(), any())).thenReturn(voidCall);
        final Set<String> queryParams = new ImmutableSet.Builder<String>().add("professional").build();
        when(request.queryParams()).thenReturn(queryParams);
        // trigger and assert
        assertEquals(user, service.createEmail(request, response));
    }

    @Test
    public void test_user_email_duplicate_email() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        when(request.body()).thenReturn(gson.toJson(user));
        when(psqlException.getSQLState()).thenReturn(Constants.PSQL_ERROR_CODE.UNIQUE_VIOLATION.code);
        when(query.executeUpdate()).thenThrow(sql2oException);
        // trigger and assert
        assertEquals(new BaseResponse.Builder().duplicate(User.class).build(), service.createEmail(request, response));
    }

    @Test
    public void test_user_email_untracked_psql_error() throws Exception {
        // mock
        final User user = new User();
        user.id = UUID.randomUUID();
        user.email = "test@test.com";
        when(request.body()).thenReturn(gson.toJson(user));
        when(psqlException.getSQLState()).thenReturn(Constants.PSQL_ERROR_CODE.UNTRACKED_ERROR.code);
        when(query.executeUpdate()).thenThrow(sql2oException);
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error().build(), service.createEmail(request, response));
    }

    @Test
    public void test_user_email_verify_success() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        user.id = UUID.randomUUID();
        user.emailVerificationNonce = UUID.randomUUID();
        when(uuidProvider.randomUUID()).thenReturn(user.id, user.emailVerificationNonce);
        when(request.body()).thenReturn(gson.toJson(user));
        when(query.executeUpdate()).thenReturn(connection);
        when(exampleApi.multipart(any(), any(), any(), any(), any(), any(), any())).thenReturn(voidCall);
        // trigger and assert
        assertEquals(user, service.createEmail(request, response));
        // mock
        when(request.params(":id")).thenReturn(user.id.toString());
        when(request.params(":nonce")).thenReturn(user.emailVerificationNonce.toString());
        when(query.executeAndFetchFirst(User.class)).thenReturn(user);
        // trigger and assert
        assertEquals(Constants.EMPTY_RESPONSE, service.verifyEmail(request, response));
    }

    @Test
    public void test_user_email_verify_missing_id() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        user.id = UUID.randomUUID();
        user.emailVerificationNonce = UUID.randomUUID();
        when(uuidProvider.randomUUID()).thenReturn(user.id, user.emailVerificationNonce);
        when(request.body()).thenReturn(gson.toJson(user));
        when(query.executeUpdate()).thenReturn(connection);
        when(exampleApi.multipart(any(), any(), any(), any(), any(), any(), any())).thenReturn(voidCall);
        // trigger and assert
        assertEquals(user, service.createEmail(request, response));
        // mock
        when(request.params(":id")).thenReturn(null);
        when(request.params(":nonce")).thenReturn(user.emailVerificationNonce.toString());
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error(new Error("id",
                new Errors.MissingPathParameterException())).build(), service.verifyEmail(request, response));
    }

    @Test
    public void test_user_email_verify_missing_nonce() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        user.id = UUID.randomUUID();
        user.emailVerificationNonce = UUID.randomUUID();
        when(uuidProvider.randomUUID()).thenReturn(user.id, user.emailVerificationNonce);
        when(request.body()).thenReturn(gson.toJson(user));
        when(query.executeUpdate()).thenReturn(connection);
        when(exampleApi.multipart(any(), any(), any(), any(), any(), any(), any())).thenReturn(voidCall);
        // trigger and assert
        assertEquals(user, service.createEmail(request, response));
        // mock
        when(request.params(":id")).thenReturn(user.id.toString());
        when(request.params(":nonce")).thenReturn("");
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error(new Error("nonce",
                new Errors.MissingPathParameterException())).build(), service.verifyEmail(request, response));
    }

    @Test
    public void test_user_email_verify_missing_id_and_nonce() throws Exception {
        // mock
        final User user = new User();
        user.email = "test@test.com";
        user.id = UUID.randomUUID();
        user.emailVerificationNonce = UUID.randomUUID();
        when(uuidProvider.randomUUID()).thenReturn(user.id, user.emailVerificationNonce);
        when(request.body()).thenReturn(gson.toJson(user));
        when(query.executeUpdate()).thenReturn(connection);
        when(exampleApi.multipart(any(), any(), any(), any(), any(), any(), any())).thenReturn(voidCall);
        // trigger and assert
        assertEquals(user, service.createEmail(request, response));
        // mock
        when(request.params(":id")).thenReturn("");
        when(request.params(":nonce")).thenReturn(null);
        // trigger and assert
        assertEquals(new BaseResponse.Builder().error(new Error("id",
                new Errors.MissingPathParameterException()), new Error("nonce",
                new Errors.MissingPathParameterException())).build(), service.verifyEmail(request, response));
    }
*/
}
