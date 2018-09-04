package com.abtingramian.service.route.form;

import com.abtingramian.service.common.config.Config;
import com.abtingramian.service.common.test.BaseRouteTest;
import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.api.RickAndMortyApi;
import com.abtingramian.service.data.source.FormRepository;
import com.google.gson.Gson;
import org.mockito.Mock;
import org.postgresql.util.PSQLException;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import retrofit2.Call;
import spark.Request;
import spark.Response;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public abstract class BaseFormRouteTest extends BaseRouteTest {

    protected final Gson gson = new Gson();
    @Mock
    protected Request request;
    @Mock
    protected Response response;
    @Mock
    protected Sql2oException sql2oException;
    @Mock
    protected PSQLException psqlException;
    @Mock
    protected Query query;
    @Mock
    protected Connection connection;
    @Mock
    protected UUIDProvider uuidProvider;
    @Mock
    protected Sql2o sql2o;
    @Mock
    protected RickAndMortyApi rickAndMortyApi;
    @Mock
    protected Call<Void> voidCall;
    protected FormService service;

    @Override
    public void setUp() {
        super.setUp();
        // common mocks
        final Config config = new Config();
        config.debug = true;
        service = new FormService(gson, new FormRepository(sql2o, uuidProvider));
        when(sql2o.beginTransaction()).thenReturn(connection);
        when(sql2o.open()).thenReturn(connection);
        when(connection.createQuery(any())).thenReturn(query);
        when(connection.commit()).thenReturn(sql2o);
        when(query.bind(any())).thenReturn(query);
        when(query.addParameter(anyString(), anyString())).thenReturn(query);
        when(query.addParameter(anyString(), any(UUID.class))).thenReturn(query);
        when(query.addParameter(anyString(), anyInt())).thenReturn(query);
        when(query.setAutoDeriveColumnNames(anyBoolean())).thenReturn(query);
        when(query.addToBatch()).thenReturn(query);
        when(query.executeBatch()).thenReturn(connection);
        when(sql2oException.getCause()).thenReturn(psqlException);
    }

}
