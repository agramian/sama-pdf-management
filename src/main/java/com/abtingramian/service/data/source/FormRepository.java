package com.abtingramian.service.data.source;

import ca.krasnay.sqlbuilder.SelectBuilder;
import com.abtingramian.service.common.util.Constants.PSQL_ERROR_CODE;
import com.abtingramian.service.common.util.SQLBuildertUtil;
import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.model.Form;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import javafx.util.Pair;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.postgresql.util.PSQLException;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormRepository {

    private final Sql2o sql2o;
    private final UUIDProvider uuidProvider;
    private final Gson gson;

    public FormRepository(final Sql2o sql2o, final UUIDProvider uuidProvider, final Gson gson) {
        this.sql2o = sql2o;
        this.uuidProvider = uuidProvider;
        this.gson = gson;
    }

    public Pair<@NonNull PSQL_ERROR_CODE, @Nullable Form> fillForm(@Nonnull final Integer id, @Nonnull final String json) {
        /*
        // insert a new form and assign them roles in a transaction
        try (final Connection connection = sql2o.beginTransaction()) {
            // insert form
            connection.createQuery("insert into characters (id, name) "
                    + "values (:id, :name)")
                    .bind(form)
                    .executeUpdate();
            // insert form roles
            final Query query = connection.createQuery("insert into user_role(user_id, role_id) VALUES (:userId, :roleId)");
            // all users are members
            query.addParameter("userId", form.id).addParameter("roleId", Role.MEMBER).addToBatch();
            if (isProfessional) {
                // add the professional role if necessary
                query.addParameter("userId", form.id).addParameter("roleId", Role.PROFESSIONAL).addToBatch();
            }
            query.executeBatch();
            // commit transaction
            connection.commit();
            return new Pair<>(PSQL_ERROR_CODE.SUCCESSFUL_COMPLETION, form);
        } catch (final Sql2oException e) {
            e.printStackTrace();
            if (e.getCause() instanceof PSQLException) {
                return new Pair<>(PSQL_ERROR_CODE.fromCode(((PSQLException) e.getCause()).getSQLState()), null);
            }
            return new Pair<>(PSQL_ERROR_CODE.UNTRACKED_ERROR, null);
        }*/
        return null;
    }

    public Pair<@NonNull PSQL_ERROR_CODE, @Nullable List<Form>> getForm(@Nullable final Integer id,
                                                                        @Nullable final String state,
                                                                        @Nullable final Integer planId,
                                                                        @Nullable final Integer medicationId,
                                                                        @Nullable final Integer payerId) {
        try (final Connection connection = sql2o.open()) {
            final SelectBuilder selectBuilder = new SelectBuilder().from("form");
            final Map<String, Object> whereClauses = new HashMap<>();
            if (id != null) {
                SQLBuildertUtil.addWhereClauseToSelectBuilder(selectBuilder, "id");
                whereClauses.put("id", id);
            } else {
                if (!Strings.isNullOrEmpty(state)) {
                    SQLBuildertUtil.addWhereClauseToSelectBuilder(selectBuilder, "state");
                    whereClauses.put("state", state);
                }
                if (planId != null) {
                    SQLBuildertUtil.addWhereClauseToSelectBuilder(selectBuilder, "planId");
                    whereClauses.put("planId", planId);
                }
                if (medicationId != null) {
                    SQLBuildertUtil.addWhereClauseToSelectBuilder(selectBuilder, "medicationId");
                    whereClauses.put("medicationId", medicationId);
                }
                if (payerId != null) {
                    SQLBuildertUtil.addWhereClauseToSelectBuilder(selectBuilder, "payerId");
                    whereClauses.put("payerId", payerId);
                }
            }
            final Query query = connection.createQuery(selectBuilder.toString());
            whereClauses.forEach(query::addParameter);
            return new Pair<>(PSQL_ERROR_CODE.SUCCESSFUL_COMPLETION, query.setAutoDeriveColumnNames(true).executeAndFetch(Form.class));
        } catch (final Sql2oException e) {
            e.printStackTrace();
            if (e.getCause() instanceof PSQLException) {
                return new Pair<>(PSQL_ERROR_CODE.fromCode(((PSQLException) e.getCause()).getSQLState()), null);
            }
            return new Pair<>(PSQL_ERROR_CODE.UNTRACKED_ERROR, null);
        }
    }

}
