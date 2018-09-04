package com.abtingramian.service.data.source;

import com.abtingramian.service.common.util.Constants.PSQL_ERROR_CODE;
import com.abtingramian.service.common.util.UUIDProvider;
import com.abtingramian.service.data.model.Form;
import com.google.common.base.Strings;
import javafx.util.Pair;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.postgresql.util.PSQLException;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import javax.annotation.Nonnull;
import java.util.List;

public class FormRepository {

    private final Sql2o sql2o;
    private final UUIDProvider uuidProvider;

    public FormRepository(final Sql2o sql2o, final UUIDProvider uuidProvider) {
        this.sql2o = sql2o;
        this.uuidProvider = uuidProvider;
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
/*
:state - The state associated with the form
:id - Id of the form
:planId - the Id of the health plan associated with the form
:medicationId - the medication Id
:payerId - the payer Id

 */
    public Pair<@NonNull PSQL_ERROR_CODE, @Nullable List<Form>> getForm(@Nullable final Integer id,
                                                                        @Nullable final String state,
                                                                        @Nullable final Integer planId,
                                                                        @Nullable final Integer medicationId,
                                                                        @Nullable final Integer payerId) {
        try (final Connection connection = sql2o.open()) {
            Query query;
            if (id != null) {
                query = connection.createQuery("select * from form where id = :id").addParameter("id", id);
            } else {
                boolean hasPreviousWhereClause = false;
                String stringQuery = "select * from form where ";
                if (!Strings.isNullOrEmpty(state)) {
                    stringQuery += "state = :state";
                    hasPreviousWhereClause = true;
                }
                if (planId != null) {
                    stringQuery += String.format(" %splan_id = :planId", hasPreviousWhereClause ? " AND " : "");
                    hasPreviousWhereClause = true;
                }
                if (medicationId != null) {
                    stringQuery += String.format(" %smedication_id = :medicationId", hasPreviousWhereClause ? " AND " : "");
                    hasPreviousWhereClause = true;
                }
                if (payerId != null) {
                    stringQuery += String.format(" %spayer_id = :payerId", hasPreviousWhereClause ? " AND " : "");
                }
                query = connection.createQuery(stringQuery);
                if (!Strings.isNullOrEmpty(state)) {
                    query.addParameter("state", state);
                }
                if (planId != null) {
                    query.addParameter("planId", planId);
                }
                if (medicationId != null) {
                    query.addParameter("medicationId", medicationId);
                }
                if (payerId != null) {
                    query.addParameter("payerId", payerId);
                }
            }
            final List<Form> form = query.setAutoDeriveColumnNames(true).executeAndFetch(Form.class);
            return new Pair<>(PSQL_ERROR_CODE.SUCCESSFUL_COMPLETION, form);
        } catch (final Sql2oException e) {
            e.printStackTrace();
            if (e.getCause() instanceof PSQLException) {
                return new Pair<>(PSQL_ERROR_CODE.fromCode(((PSQLException) e.getCause()).getSQLState()), null);
            }
            return new Pair<>(PSQL_ERROR_CODE.UNTRACKED_ERROR, null);
        }
    }

}
