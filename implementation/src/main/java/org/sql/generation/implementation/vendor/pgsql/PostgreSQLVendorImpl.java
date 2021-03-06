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

package org.sql.generation.implementation.vendor.pgsql;

import org.sql.generation.api.grammar.factories.pgsql.PgSQLDataTypeFactory;
import org.sql.generation.api.grammar.factories.pgsql.PgSQLManipulationFactory;
import org.sql.generation.api.vendor.PostgreSQLVendor;
import org.sql.generation.api.vendor.SQLVendor;
import org.sql.generation.implementation.grammar.factories.pgsql.PgSQLDataTypeFactoryImpl;
import org.sql.generation.implementation.grammar.factories.pgsql.PgSQLManipulationFactoryImpl;
import org.sql.generation.implementation.transformation.pgsql.PostgreSQLProcessor;
import org.sql.generation.implementation.transformation.spi.SQLProcessorAggregator;
import org.sql.generation.implementation.vendor.DefaultVendor;

/**
 * 
 * @author Stanislav Muhametsin
 */
public class PostgreSQLVendorImpl extends DefaultVendor
    implements PostgreSQLVendor
{
    protected static final Callback<PgSQLDataTypeFactory> PG_DATA_TYPE_FACTORY = new Callback<PgSQLDataTypeFactory>()
    {
        public PgSQLDataTypeFactory get( SQLVendor vendor, SQLProcessorAggregator processor )
        {
            return new PgSQLDataTypeFactoryImpl( (PostgreSQLVendor) vendor, processor );
        }
    };

    protected static final Callback<PgSQLManipulationFactory> PG_MANIPULATION_FACTORY = new Callback<PgSQLManipulationFactory>()
    {
        public PgSQLManipulationFactory get( SQLVendor vendor, SQLProcessorAggregator processor )
        {
            return new PgSQLManipulationFactoryImpl( (PostgreSQLVendor) vendor, processor );
        }
    };

    protected static final ProcessorCallback PG_PROCESSOR = new ProcessorCallback()
    {
        public SQLProcessorAggregator get( SQLVendor vendor )
        {
            return new PostgreSQLProcessor( vendor );
        }
    };

    private boolean _legacyOffsetAndLimit;

    public PostgreSQLVendorImpl()
    {
        super( PG_PROCESSOR, BOOLEAN_FACTORY, COLUMNS_FACTORY, LITERAL_FACTORY, MODIFICATION_FACTORY, QUERY_FACTORY,
            TABLE_REFERENCE_FACTORY, DEFINITION_FACTORY, PG_MANIPULATION_FACTORY, PG_DATA_TYPE_FACTORY );
        this._legacyOffsetAndLimit = false;
    }

    @Override
    public PgSQLDataTypeFactory getDataTypeFactory()
    {
        return (PgSQLDataTypeFactory) super.getDataTypeFactory();
    }

    @Override
    public PgSQLManipulationFactory getManipulationFactory()
    {
        return (PgSQLManipulationFactory) super.getManipulationFactory();
    }

    public boolean legacyOffsetAndLimit()
    {
        return this._legacyOffsetAndLimit;
    }

    public void setLegacyOffsetAndLimit( boolean useLegacyOffsetAndLimit )
    {
        this._legacyOffsetAndLimit = useLegacyOffsetAndLimit;
    }

}
