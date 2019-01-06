// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Saching/Downloads/backend/LibraryManagementSystem/conf/routes
// @DATE:Sun Jan 06 07:46:28 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getBookByISBN: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getBookByISBN",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBook"})
        }
      """
    )
  
    // @LINE:17
    def addDvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addDvd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addDvd"})
        }
      """
    )
  
    // @LINE:14
    def books: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.books",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
        }
      """
    )
  
    // @LINE:19
    def getDVDByISBN: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getDVDByISBN",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDvd"})
        }
      """
    )
  
    // @LINE:22
    def burrowBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.burrowBook",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "burrowBook"})
        }
      """
    )
  
    // @LINE:16
    def addBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addBook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBook"})
        }
      """
    )
  
    // @LINE:25
    def returnDvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnDvd",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "returnDvd"})
        }
      """
    )
  
    // @LINE:24
    def burrowDvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.burrowDvd",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "burrowDvd"})
        }
      """
    )
  
    // @LINE:15
    def dvds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.dvds",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dvds"})
        }
      """
    )
  
    // @LINE:23
    def returnBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnBook",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "returnBook"})
        }
      """
    )
  
    // @LINE:26
    def getAllItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAllItems",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLibraryItems"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:20
    def deleteBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteBook",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteBook"})
        }
      """
    )
  
    // @LINE:27
    def generateReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.generateReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reports"})
        }
      """
    )
  
    // @LINE:21
    def deleteDvd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteDvd",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDvd"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
