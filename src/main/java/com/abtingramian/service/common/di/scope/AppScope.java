package com.abtingramian.service.common.di.scope;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A custom scope to restrict the lifetime of form related bound instances to match
 * the lifetime of the form's session.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
