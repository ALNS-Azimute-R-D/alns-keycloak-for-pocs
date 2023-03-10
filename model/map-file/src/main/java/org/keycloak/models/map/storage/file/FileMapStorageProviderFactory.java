/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.models.map.storage.file;

import org.keycloak.Config;
import org.keycloak.common.Profile;
import org.keycloak.component.AmphibianProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.map.storage.MapStorageProvider;
import org.keycloak.models.map.storage.MapStorageProviderFactory;
import org.keycloak.provider.EnvironmentDependentProviderFactory;

/**
 * A {@link MapStorageProviderFactory} that creates file-based {@link MapStorageProvider}s.
 *
 * @author <a href="mailto:sguilhen@redhat.com">Stefan Guilhen</a>
 */
public class FileMapStorageProviderFactory implements AmphibianProviderFactory<MapStorageProvider>,
        MapStorageProviderFactory,
        EnvironmentDependentProviderFactory {

    public static final String PROVIDER_ID = "file";
    private Config.Scope config;

    @Override
    public MapStorageProvider create(KeycloakSession session) {
        return new FileMapStorageProvider();
    }

    @Override
    public String getHelpText() {
        return "File Map Storage";
    }

    @Override
    public boolean isSupported() {
        return Profile.isFeatureEnabled(Profile.Feature.MAP_STORAGE);
    }

    @Override
    public void init(Config.Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }
}
