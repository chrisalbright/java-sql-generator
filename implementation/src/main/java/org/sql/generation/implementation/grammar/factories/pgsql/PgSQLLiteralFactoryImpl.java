/*
 * Copyright (c) 2011, Stanislav Muhametsin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.sql.generation.implementation.grammar.factories.pgsql;

import java.util.Arrays;

import org.sql.generation.api.grammar.common.ValueExpression;
import org.sql.generation.api.grammar.factories.pgsql.PgSQLLiteralFactory;
import org.sql.generation.api.grammar.literals.pgsql.DynamicRow;
import org.sql.generation.implementation.grammar.factories.DefaultLiteralFactory;
import org.sql.generation.implementation.grammar.literals.pgsql.DynamicRowImpl;

/**
 * 
 * @author Stanislav Muhametsin
 */
public class PgSQLLiteralFactoryImpl extends DefaultLiteralFactory
    implements PgSQLLiteralFactory
{

    public DynamicRow dr( ValueExpression... expressions )
    {
        return new DynamicRowImpl( Arrays.asList( expressions ) );
    }

}
