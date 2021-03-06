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

package org.sql.generation.api.qi4j;

import org.qi4j.api.injection.scope.This;
import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.service.ServiceComposite;
import org.sql.generation.api.vendor.SQLVendor;

@Mixins(
{
    SQLVendorServiceComposite.SQLVendorServiceMixin.class
})
public interface SQLVendorServiceComposite
    extends SQLVendorService, ServiceComposite
{
    public class SQLVendorServiceMixin
        implements SQLVendorService
    {

        @This
        private ServiceComposite _meAsService;

        /*
         * (non-Javadoc)
         * 
         * @see org.trinity.db.runtime.sql.SQLVendorService#getSQLVendor()
         */
        public SQLVendor getSQLVendor()
        {
            return this._meAsService.metaInfo( SQLVendor.class );
        }

    }
}