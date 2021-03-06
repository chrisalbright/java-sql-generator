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

package org.sql.generation.api.grammar.query;

/**
 * This syntax element represents the column reference in {@code SELECT <column reference>} clause, where the column
 * reference is column name, either with table name or without.
 * 
 * @author Stanislav Muhametsin
 */
public interface ColumnReferenceByName
    extends ColumnReference
{
    /**
     * Gets the table name of this column. Might be {@code null}.
     * 
     * @return The table name of this column. Might be {@code null}.
     */
    public String getTableName();

    /**
     * Gets the column name of this column.
     * 
     * @return The column name of this column.
     */
    public String getColumnName();

}
