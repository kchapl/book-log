package controllers

import model.Book
import javax.inject.Inject
import scala.concurrent.Future

import play.api.mvc._
import play.api.libs.ws._
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(ws: WSClient) extends Controller {

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
