package com.abtingramian.service.route.di.component;


import com.abtingramian.service.Service;
import com.abtingramian.service.common.di.module.RoutesModule;
import com.abtingramian.service.common.di.scope.AppScope;
import com.abtingramian.service.route.form.di.module.FormModule;
import dagger.Subcomponent;

/**
 * This is a Dagger {@link Subcomponent} which will inherit and extend the object graph of a parent component
 * to give access to the route modules.
 */
@AppScope
@Subcomponent(
        modules = {
                RoutesModule.class,
                FormModule.class
        }
)
public interface RoutesComponent {

    void inject(final Service service);

}
