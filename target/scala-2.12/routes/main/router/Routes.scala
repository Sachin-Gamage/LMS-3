// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Saching/Downloads/backend/LibraryManagementSystem/conf/routes
// @DATE:Sun Jan 06 07:46:28 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.HomeController.books()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dvds""", """controllers.HomeController.dvds"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addBook""", """controllers.HomeController.addBook()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addDvd""", """controllers.HomeController.addDvd()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBook""", """controllers.HomeController.getBookByISBN()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDvd""", """controllers.HomeController.getDVDByISBN()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteBook""", """controllers.HomeController.deleteBook()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDvd""", """controllers.HomeController.deleteDvd()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """burrowBook""", """controllers.HomeController.burrowBook()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """returnBook""", """controllers.HomeController.returnBook()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """burrowDvd""", """controllers.HomeController.burrowDvd()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """returnDvd""", """controllers.HomeController.returnDvd()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLibraryItems""", """controllers.HomeController.getAllItems()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reports""", """controllers.HomeController.generateReport()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_books2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_HomeController_books2_invoker = createInvoker(
    HomeController_0.books(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "books",
      Nil,
      "GET",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_dvds3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dvds")))
  )
  private[this] lazy val controllers_HomeController_dvds3_invoker = createInvoker(
    HomeController_0.dvds,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "dvds",
      Nil,
      "GET",
      this.prefix + """dvds""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_addBook4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addBook")))
  )
  private[this] lazy val controllers_HomeController_addBook4_invoker = createInvoker(
    HomeController_0.addBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addBook",
      Nil,
      "POST",
      this.prefix + """addBook""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_addDvd5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addDvd")))
  )
  private[this] lazy val controllers_HomeController_addDvd5_invoker = createInvoker(
    HomeController_0.addDvd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addDvd",
      Nil,
      "POST",
      this.prefix + """addDvd""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_getBookByISBN6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBook")))
  )
  private[this] lazy val controllers_HomeController_getBookByISBN6_invoker = createInvoker(
    HomeController_0.getBookByISBN(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getBookByISBN",
      Nil,
      "GET",
      this.prefix + """getBook""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_getDVDByISBN7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDvd")))
  )
  private[this] lazy val controllers_HomeController_getDVDByISBN7_invoker = createInvoker(
    HomeController_0.getDVDByISBN(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getDVDByISBN",
      Nil,
      "GET",
      this.prefix + """getDvd""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_deleteBook8_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteBook")))
  )
  private[this] lazy val controllers_HomeController_deleteBook8_invoker = createInvoker(
    HomeController_0.deleteBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteBook",
      Nil,
      "DELETE",
      this.prefix + """deleteBook""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HomeController_deleteDvd9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDvd")))
  )
  private[this] lazy val controllers_HomeController_deleteDvd9_invoker = createInvoker(
    HomeController_0.deleteDvd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteDvd",
      Nil,
      "DELETE",
      this.prefix + """deleteDvd""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HomeController_burrowBook10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("burrowBook")))
  )
  private[this] lazy val controllers_HomeController_burrowBook10_invoker = createInvoker(
    HomeController_0.burrowBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "burrowBook",
      Nil,
      "PUT",
      this.prefix + """burrowBook""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HomeController_returnBook11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("returnBook")))
  )
  private[this] lazy val controllers_HomeController_returnBook11_invoker = createInvoker(
    HomeController_0.returnBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnBook",
      Nil,
      "PUT",
      this.prefix + """returnBook""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_burrowDvd12_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("burrowDvd")))
  )
  private[this] lazy val controllers_HomeController_burrowDvd12_invoker = createInvoker(
    HomeController_0.burrowDvd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "burrowDvd",
      Nil,
      "PUT",
      this.prefix + """burrowDvd""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_returnDvd13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("returnDvd")))
  )
  private[this] lazy val controllers_HomeController_returnDvd13_invoker = createInvoker(
    HomeController_0.returnDvd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnDvd",
      Nil,
      "PUT",
      this.prefix + """returnDvd""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HomeController_getAllItems14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLibraryItems")))
  )
  private[this] lazy val controllers_HomeController_getAllItems14_invoker = createInvoker(
    HomeController_0.getAllItems(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAllItems",
      Nil,
      "GET",
      this.prefix + """getLibraryItems""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_generateReport15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reports")))
  )
  private[this] lazy val controllers_HomeController_generateReport15_invoker = createInvoker(
    HomeController_0.generateReport(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "generateReport",
      Nil,
      "GET",
      this.prefix + """reports""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:14
    case controllers_HomeController_books2_route(params@_) =>
      call { 
        controllers_HomeController_books2_invoker.call(HomeController_0.books())
      }
  
    // @LINE:15
    case controllers_HomeController_dvds3_route(params@_) =>
      call { 
        controllers_HomeController_dvds3_invoker.call(HomeController_0.dvds)
      }
  
    // @LINE:16
    case controllers_HomeController_addBook4_route(params@_) =>
      call { 
        controllers_HomeController_addBook4_invoker.call(HomeController_0.addBook())
      }
  
    // @LINE:17
    case controllers_HomeController_addDvd5_route(params@_) =>
      call { 
        controllers_HomeController_addDvd5_invoker.call(HomeController_0.addDvd())
      }
  
    // @LINE:18
    case controllers_HomeController_getBookByISBN6_route(params@_) =>
      call { 
        controllers_HomeController_getBookByISBN6_invoker.call(HomeController_0.getBookByISBN())
      }
  
    // @LINE:19
    case controllers_HomeController_getDVDByISBN7_route(params@_) =>
      call { 
        controllers_HomeController_getDVDByISBN7_invoker.call(HomeController_0.getDVDByISBN())
      }
  
    // @LINE:20
    case controllers_HomeController_deleteBook8_route(params@_) =>
      call { 
        controllers_HomeController_deleteBook8_invoker.call(HomeController_0.deleteBook())
      }
  
    // @LINE:21
    case controllers_HomeController_deleteDvd9_route(params@_) =>
      call { 
        controllers_HomeController_deleteDvd9_invoker.call(HomeController_0.deleteDvd())
      }
  
    // @LINE:22
    case controllers_HomeController_burrowBook10_route(params@_) =>
      call { 
        controllers_HomeController_burrowBook10_invoker.call(HomeController_0.burrowBook())
      }
  
    // @LINE:23
    case controllers_HomeController_returnBook11_route(params@_) =>
      call { 
        controllers_HomeController_returnBook11_invoker.call(HomeController_0.returnBook())
      }
  
    // @LINE:24
    case controllers_HomeController_burrowDvd12_route(params@_) =>
      call { 
        controllers_HomeController_burrowDvd12_invoker.call(HomeController_0.burrowDvd())
      }
  
    // @LINE:25
    case controllers_HomeController_returnDvd13_route(params@_) =>
      call { 
        controllers_HomeController_returnDvd13_invoker.call(HomeController_0.returnDvd())
      }
  
    // @LINE:26
    case controllers_HomeController_getAllItems14_route(params@_) =>
      call { 
        controllers_HomeController_getAllItems14_invoker.call(HomeController_0.getAllItems())
      }
  
    // @LINE:27
    case controllers_HomeController_generateReport15_route(params@_) =>
      call { 
        controllers_HomeController_generateReport15_invoker.call(HomeController_0.generateReport())
      }
  }
}
