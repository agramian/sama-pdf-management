package com.abtingramian.service.route.form;

import com.abtingramian.service.common.middleware.Errors;
import com.abtingramian.service.common.util.Constants;
import com.abtingramian.service.common.util.RequestUtil;
import com.abtingramian.service.data.model.*;
import com.abtingramian.service.data.model.Error;
import com.abtingramian.service.data.source.FormRepository;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.util.Pair;
import spark.Request;
import spark.Response;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class FormService implements FormContract.Service {

    private final Gson gson;
    private final FormRepository formRepository;

    public FormService(final Gson gson, final FormRepository formRepository) {
        this.gson = gson;
        this.formRepository = formRepository;
    }
/*
    @Override
    public Responsive createCharacter(final Request request, final Response response) throws Errors.RequestException {
        if (Strings.isNullOrEmpty(request.body())) {
            // return error on empty body
            throw new Errors.MissingPostBodyException();
        }
        try {
            final Character form = gson.fromJson(request.body(), Character.class);
            if (form.id == null) {
                // return error on missing email
                response.status(400);
                return new BaseResponse.Builder().error(new Error("id",
                        new Errors.MissingPostBodyFieldException())).build();
            }
            if (Strings.isNullOrEmpty(form.name)) {
                // return error on missing email
                response.status(400);
                return new BaseResponse.Builder().error(new Error("id",
                        new Errors.MissingPostBodyFieldException())).build();
            }
            // attempt to create form entry in db
            final Pair<Constants.PSQL_ERROR_CODE, Character> result = characterRepository.createCharacter(form);
            switch (result.getKey()) {
                case SUCCESSFUL_COMPLETION:
                    response.status(201);
                    return result.getValue();
                case UNIQUE_VIOLATION:
                    response.status(409);
                    return new BaseResponse.Builder().duplicate(Character.class).build();
                default:
                    response.status(500);
                    return new BaseResponse.Builder().error().build();
            }
        } catch (final JsonSyntaxException jsonSyntaxException) {
            jsonSyntaxException.printStackTrace();
            throw new Errors.InvalidPostBodyException();
        }
    }

    @Override
    public Responsive getCharacters(final Request request, final Response response) throws Errors.RequestException {
        // check if characters exist
        final Pair<Constants.PSQL_ERROR_CODE, List<Character>> getCharactersResult = characterRepository.getCharacters();
        switch (getCharactersResult.getKey()) {
            case SUCCESSFUL_COMPLETION:
                final List<Character> characters = getCharactersResult.getValue();
                if (characters != null && !characters.isEmpty()) {
                    response.status(200);
                    final CharactersResponse charactersResponse = new CharactersResponse();
                    charactersResponse.characters = characters;
                    return charactersResponse;
                } else {
                    response.status(404);
                    return Errors.ERROR_404;
                }
            default:
                response.status(500);
                return new BaseResponse.Builder().error().build();
        }
    }

    @Override
    public Responsive getCharacter(final Request request, final Response response) throws Errors.RequestException {
        // check for missing path parameters
        final List<Error> errors = new ArrayList<>();
        final String characterId = request.params(":id");
        if (Strings.isNullOrEmpty(characterId)) {
            errors.add(new Error("id", new Errors.MissingPathParameterException()));
        }
        if (!errors.isEmpty()) {
            // return error if any problems were found with the request
            response.status(400);
            return new BaseResponse.Builder().error(errors.toArray(new Error[errors.size()])).build();
        }
        // check if form exists
        final Pair<Constants.PSQL_ERROR_CODE, Character> getCharacterResult = characterRepository.getCharacter(Integer.valueOf(request.params(":id")));
        switch (getCharacterResult.getKey()) {
            case SUCCESSFUL_COMPLETION:
                final Character form = getCharacterResult.getValue();
                if (form != null) {
                    response.status(200);
                    return form;
                } else {
                    response.status(404);
                    return Errors.ERROR_404;
                }
            default:
                response.status(500);
                return new BaseResponse.Builder().error().build();
        }
    }

    @Override
    public Responsive getCharacterEpisodes(Request request, Response response) throws Errors.RequestException {
        // check for missing path parameters
        final List<Error> errors = new ArrayList<>();
        final String characterId = request.params(":id");
        if (Strings.isNullOrEmpty(characterId)) {
            errors.add(new Error("id", new Errors.MissingPathParameterException()));
        }
        if (!errors.isEmpty()) {
            // return error if any problems were found with the request
            response.status(400);
            return new BaseResponse.Builder().error(errors.toArray(new Error[errors.size()])).build();
        }
        // check if form exists
        final Pair<Constants.PSQL_ERROR_CODE, List<Episode>> getCharacterEpisodesResult = characterRepository.getCharacterEpisodes(Integer.valueOf(request.params(":id")));
        switch (getCharacterEpisodesResult.getKey()) {
            case SUCCESSFUL_COMPLETION:
                final List<Episode> episodes = getCharacterEpisodesResult.getValue();
                if (episodes != null && !episodes.isEmpty()) {
                    response.status(200);
                    final EpisodesResponse episodesResponse = new EpisodesResponse();
                    episodesResponse.episodes = episodes;
                    return episodesResponse;
                } else {
                    response.status(404);
                    return Errors.ERROR_404;
                }
            default:
                response.status(500);
                return new BaseResponse.Builder().error().build();
        }
    }
*/
    @Override
    public Responsive getForm(Request request, Response response) throws Errors.RequestException {
        // check for missing path parameters
        final List<Error> errors = new ArrayList<>();
        if (Strings.isNullOrEmpty(request.queryParams("id"))
                && Strings.isNullOrEmpty(request.queryParams("state"))
                && Strings.isNullOrEmpty(request.queryParams("planId"))
                && Strings.isNullOrEmpty(request.queryParams("medicationId"))
                && Strings.isNullOrEmpty(request.queryParams("payerId"))) {
            errors.add(new Error("all", new Errors.MissingPathParameterException()));
        }
        if (!errors.isEmpty()) {
            // return error if any problems were found with the request
            response.status(400);
            return new BaseResponse.Builder().error(errors.toArray(new Error[errors.size()])).build();
        }
        final Pair<Constants.PSQL_ERROR_CODE, List<Form>> getFormResult = formRepository.getForm(RequestUtil.getRequestParamAsInteger(request.queryParams("id")),
                request.queryParams("state"),
                RequestUtil.getRequestParamAsInteger(request.queryParams("planId")),
                RequestUtil.getRequestParamAsInteger(request.queryParams("medicationId")),
                RequestUtil.getRequestParamAsInteger(request.queryParams("payerId")));
        switch (getFormResult.getKey()) {
            case SUCCESSFUL_COMPLETION:
                final List<Form> forms = getFormResult.getValue();
                if (forms != null) {
                    //processForm(forms.get(0));
                    response.status(200);
                    final FormResponse formResponse = new FormResponse();
                    formResponse.forms = forms;
                    return formResponse;
                } else {
                    response.status(404);
                    return Errors.ERROR_404;
                }
            default:
                response.status(500);
                return new BaseResponse.Builder().error().build();
        }
    }

    @Override
    public Responsive fillOutForm(Request request, Response response) throws Errors.RequestException {
        return null;
    }

    private void processForm(@Nonnull final Form form) {
        final JsonArray formConfigRaw = gson.fromJson (form.formConfigRaw, JsonArray.class);
        final JsonArray formConfigFormatted = gson.fromJson (form.formConfigFormatted, JsonArray.class);
        final JsonArray substitutedForm = new JsonArray();


        // Iterated through formatted config looking for option strings and strings withing items
        formConfigFormatted.forEach(jsonElement -> {
            final JsonArray items = ((JsonObject) jsonElement).get("items").getAsJsonArray();
            items.forEach(itemJsonElement -> {

            });
        });
    }

}
