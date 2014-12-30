/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.isis.core.metamodel.facets.collections.collection;

import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.services.eventbus.CollectionInteractionEvent;
import org.apache.isis.core.metamodel.facetapi.FacetHolder;
import org.apache.isis.core.metamodel.facets.collections.interaction.CollectionInteractionFacet;
import org.apache.isis.core.metamodel.facets.collections.interaction.CollectionInteractionFacetAbstract;
import org.apache.isis.core.metamodel.runtimecontext.ServicesInjector;
import org.apache.isis.core.metamodel.spec.SpecificationLoader;

public class CollectionInteractionFacetForCollectionAnnotation extends CollectionInteractionFacetAbstract {

    static CollectionInteractionFacet create(
            final Collection collection,
            final ServicesInjector servicesInjector,
            final SpecificationLoader specificationLoader,
            final FacetHolder holder) {
        Class<? extends CollectionInteractionEvent<?, ?>> collectionInteractionEventType = collection.interaction();
        return new CollectionInteractionFacetForCollectionAnnotation(
                collectionInteractionEventType, servicesInjector, specificationLoader, holder);
    }

    public CollectionInteractionFacetForCollectionAnnotation(
            final Class<? extends CollectionInteractionEvent<?, ?>> eventType,
            final ServicesInjector servicesInjector, final SpecificationLoader specificationLoader, final FacetHolder holder) {
        super(eventType, holder, servicesInjector, specificationLoader);
    }

}