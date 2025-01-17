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
package org.jkiss.dbeaver.ext.firebird.model.plan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Describes each item of firebird plan as regular expression. Items are used
 * for construction of FireBirdPlanTokenMatcher.
 *
 * @author tomashorak@post.cz
 */
enum FireBirdPlanToken {
	PLAN("\\GPLAN\\b"), 
	JOIN("\\GJOIN\\b"), 
	NATURAL("\\GNATURAL\\b"),
	SORT_MERGE("\\GSORT\\w+MERGE\\b"),
	SORT("\\GSORT\\b"), 
	MERGE("\\GMERGE\\b"), 
	HASH("\\GHASH\\b"),
	ORDER("\\GORDER\\b"), 
	INDEX("\\GINDEX\\b"), 
	LEFTPARENTHESE("\\G\\("), 
	RIGHTPARENTHESE("\\G\\)"),
	COMMA("\\G,"),
	WHITESPACE("\\G\\s+"),
	IDENTIFICATOR("\\G\\b[\\w$]+\\b"),
	UNRECOGNIZED("\\G\\b[^\\s]+\\b");
    
	private final Pattern pattern;

    private FireBirdPlanToken(String regex) {
        pattern = Pattern.compile(regex);
    }
    
    public Matcher newMatcher(String text) {
    	Matcher matcher = pattern.matcher(text);
        return matcher;
    }
}