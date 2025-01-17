/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.auth;


import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;

import java.util.Set;

public class SMCredentials {
    @NotNull
    private final String smAccessToken;
    @Nullable
    private final String userId;
    @Nullable
    private final String smSessionId;
    @NotNull
    private final Set<String> permissions;

    public SMCredentials(
        @NotNull String smAccessToken,
        @Nullable String userId,
        @Nullable String smSessionId,
        @NotNull Set<String> permissions
    ) {
        this.smAccessToken = smAccessToken;
        this.userId = userId;
        this.smSessionId = smSessionId;
        this.permissions = permissions;
    }

    @NotNull
    public String getSmAccessToken() {
        return smAccessToken;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    @NotNull
    public Set<String> getPermissions() {
        return permissions;
    }

    @Nullable
    public String getSmSessionId() {
        return smSessionId;
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}
