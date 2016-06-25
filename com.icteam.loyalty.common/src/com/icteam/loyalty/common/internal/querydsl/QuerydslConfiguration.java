/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.icteam.loyalty.common.internal.querydsl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * Constants that make it possible to configure the Configuration component
 * programmatically.
 */
@ObjectClassDefinition(name = "Loyalty QueryDSL Configuration", id = "com.icteam.loyalty.common.internal.querydsl", pid = "com.icteam.loyalty.common.internal.querydsl", description = "Parametri di configurazione specifici per queryDSL")
public interface QuerydslConfiguration {

	@AttributeDefinition(defaultValue = "com.querydsl.sql.OracleTemplates", required = true, description = "SQLTemplates Fully Qualified Class Name")
	String sqlTemplatesFQCN();

	@AttributeDefinition(defaultValue = "false", required = true, description = "Use Literals in Configuration")
	String useLiterals();
}
