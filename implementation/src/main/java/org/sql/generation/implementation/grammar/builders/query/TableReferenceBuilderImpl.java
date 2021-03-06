/*
 * Copyright (c) 2010, Stanislav Muhametsin. All Rights Reserved.
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

package org.sql.generation.implementation.grammar.builders.query;

import org.sql.generation.api.common.NullArgumentException;
import org.sql.generation.api.grammar.builders.query.TableReferenceBuilder;
import org.sql.generation.api.grammar.query.TableReference;
import org.sql.generation.api.grammar.query.TableReferencePrimary;
import org.sql.generation.api.grammar.query.joins.JoinSpecification;
import org.sql.generation.api.grammar.query.joins.JoinType;
import org.sql.generation.implementation.grammar.common.SQLBuilderBase;
import org.sql.generation.implementation.grammar.query.joins.CrossJoinedTableImpl;
import org.sql.generation.implementation.grammar.query.joins.NaturalJoinedTableImpl;
import org.sql.generation.implementation.grammar.query.joins.QualifiedJoinedTableImpl;
import org.sql.generation.implementation.grammar.query.joins.UnionJoinedTableImpl;
import org.sql.generation.implementation.transformation.spi.SQLProcessorAggregator;

public class TableReferenceBuilderImpl extends SQLBuilderBase
    implements TableReferenceBuilder
{

    private TableReference _currentTable;

    public TableReferenceBuilderImpl( SQLProcessorAggregator processor, TableReferencePrimary startingTable )
    {
        super( processor );
        NullArgumentException.validateNotNull( "starting table", startingTable );

        this._currentTable = startingTable;
    }

    public TableReferenceBuilder addQualifiedJoin( JoinType joinType, TableReference right, JoinSpecification joinSpec )
    {
        this._currentTable = new QualifiedJoinedTableImpl( this.getProcessor(), this._currentTable, right, joinType,
            joinSpec );
        return this;
    }

    public TableReferenceBuilder addCrossJoin( TableReference right )
    {
        this._currentTable = new CrossJoinedTableImpl( this.getProcessor(), this._currentTable, right );
        return this;
    }

    public TableReferenceBuilder addNaturalJoin( JoinType joinType, TableReference right )
    {
        this._currentTable = new NaturalJoinedTableImpl( this.getProcessor(), this._currentTable, right, joinType );
        return this;
    }

    public TableReferenceBuilder addUnionJoin( TableReference right )
    {
        this._currentTable = new UnionJoinedTableImpl( this.getProcessor(), this._currentTable, right );
        return this;
    }

    public TableReference createExpression()
    {
        return this._currentTable;
    }
}