package functionaltests

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

/*
 * Copyright 2014 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import geb.spock.*
import spock.lang.PendingFeature

/**
 * @author graemerocher
 */
@Integration(applicationClass = Application)
@Rollback
class AsyncFunctionalSpec extends GebSpec {

    @PendingFeature(reason = 'pageSource == <html><head></head><body></body></html>')
    void "Test async response rendering works"() {
        when:"When an async response is rendered"
            go '/async/test'

        then:"The rendered page is correct"
            driver.pageSource.contains 'Hello'
    }

}

