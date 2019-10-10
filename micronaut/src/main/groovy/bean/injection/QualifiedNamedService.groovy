package bean.injection

import groovy.transform.CompileStatic

import javax.inject.Singleton

@Singleton
@CompileStatic
@Qualified
class QualifiedNamedService implements NamedService {

    final String name = 'qualified'
    
}
