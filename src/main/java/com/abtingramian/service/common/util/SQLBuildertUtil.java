package com.abtingramian.service.common.util;

import ca.krasnay.sqlbuilder.InsertBuilder;
import ca.krasnay.sqlbuilder.SelectBuilder;
import com.google.common.base.CaseFormat;

import javax.annotation.Nonnull;
import java.util.List;

public final class SQLBuildertUtil {

    public static void addWhereClauseToSelectBuilder(@Nonnull final SelectBuilder selectBuilder, @Nonnull final String column) {
        selectBuilder.where(String.format("%s = :%s", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, column), column));
    }

    public static void setColumnValuesOnInsertBuilder(@Nonnull final InsertBuilder insertBuilder, @Nonnull final List<String> columns) {
        columns.forEach(column -> insertBuilder.set(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, column), ":" + column));
    }

    /**
     * Prevent construction of objects of this class.
     */
    private SQLBuildertUtil() {
        throw new AssertionError();
    }

}
