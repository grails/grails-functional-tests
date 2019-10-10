package bean.injection

import io.micronaut.context.annotation.Primary

import javax.inject.Singleton

@Singleton
@Primary
class PrimaryNamedService implements NamedService {

    final String name = 'primary'

}

