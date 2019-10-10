package bean.injection

import groovy.transform.CompileStatic

import javax.inject.Named
import javax.inject.Singleton

@Singleton
@CompileStatic
@Named('special')
class SpecialNamedService implements NamedService {

    final String name = 'special'

}
