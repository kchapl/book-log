package controllers

import model.Book
import play.api.libs.ws._
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject() (
    controllerComponents: ControllerComponents,
    ws: WSClient
) extends AbstractController(controllerComponents) {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def listBooks() = TODO

  def readings = TODO

  def lookUpBook(isbn: String) = Action.async {
    for (maybeBook <- Book.lookUp(isbn, ws)) yield {
      for (book <- maybeBook) yield Ok(book.toString)
    } getOrElse Ok("no")
  }
}
