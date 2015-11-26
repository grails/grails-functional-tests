import functionaltests.*

class UrlMappings {

	static mappings = {
        "/viewBooks"(redirect: '/book/index')
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/alphaDemo"(controller: 'demo', action: 'doit', namespace: 'alpha')
        "/betaDemo"(controller: 'demo', action: 'doit', namespace: 'beta')

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(controller:"errors", action:"notFound")
		"500"(controller:"errors", action:'customErrorHandler', exception:CustomException)
	}
}
