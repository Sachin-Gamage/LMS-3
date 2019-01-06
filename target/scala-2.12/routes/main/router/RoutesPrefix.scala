// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Saching/Downloads/backend/LibraryManagementSystem/conf/routes
// @DATE:Sun Jan 06 07:46:28 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
