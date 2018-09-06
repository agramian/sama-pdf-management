package com.abtingramian.service.common.util;

import ca.krasnay.sqlbuilder.SelectBuilder;
import com.google.common.base.CaseFormat;

import javax.annotation.Nonnull;

public final class SQLBuildertUtil {

    public static void addWhereClauseToSelectBuilder(@Nonnull final SelectBuilder selectBuilder, @Nonnull final String column) {
        selectBuilder.where(String.format("%s = :%s", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, column), column));
    }

    /**
     * Prevent construction of objects of this class.
     */
    private SQLBuildertUtil() {
        throw new AssertionError();
    }

}
