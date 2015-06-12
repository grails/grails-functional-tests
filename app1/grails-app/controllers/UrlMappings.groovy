import functionaltests.*

class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(controller:"errors", action:"notFound")
		"500"(controller:"errors", action:'customError', exception:CustomException)
	}
}
