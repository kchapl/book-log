package model

import play.api.data._
import play.api.data.Forms._
import play.api.libs.ws._

import scala.concurrent.{Future, ExecutionContext}

case class Book(author: String, title: String)

object Book {

  def lookUp(isbn: String, ws: WSClient)(implicit
      ec: ExecutionContext
  ): Future[Option[Book]] = {

    //https://www.googleapis.com/books/v1/volumes?q=isbn:9781847082541
    val eventualResponse = ws
      .url("https://www.googleapis.com/books/v1/volumes")
      .withQueryStringParameters("q" -> s"isbn:$isbn")
      .get()
    for (response <- eventualResponse) yield {
      val item = (response.json \ "items").head
      for {
        title <- (item \ "volumeInfo" \ "title").asOpt[String]
        author <- (item \ "volumeInfo" \ "authors").head.asOpt[String]
      } yield Book(author, title)
    }
  }
}
