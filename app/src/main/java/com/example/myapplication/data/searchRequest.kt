package com.example.myapplication.data


class SearchRequest(
    var items: List<BookItem>,
    var totalItems: Int

                   )

class BookItem(
    var volumeInfo: VolumeInfo
              )

class VolumeInfo(
    var title: String,
    var authors: List<String>, // Just get the first one
    var description: String,
    var pageCount: Int,
    var imageLinks: ImageLinks,
    var industryIdentifiers: List<IndustryIdentifier>

                )

class ImageLinks(
    var smallThumbnail: String,
    var thumbnail : String
                )

class IndustryIdentifier(
    var identifier: String,
                        )



fun searchRequest2Book(searchRequest: SearchRequest?): MutableList<Book> {
    val bookList: MutableList<Book> = mutableListOf()

    for (i in 0 until 7) {
        if (searchRequest != null && searchRequest.items != null && searchRequest.items.size > i) {
            val item = searchRequest.items[i]
            val volumeInfo = item.volumeInfo

            val title = volumeInfo.title ?: ""
            val authors = if (volumeInfo.authors?.isNotEmpty() == true) volumeInfo.authors[0] else ""
            val description = volumeInfo.description ?: ""
            val nPages = volumeInfo.pageCount ?: 0
            val identifier =
                if (volumeInfo.industryIdentifiers?.isNotEmpty() == true) volumeInfo.industryIdentifiers[0].identifier else ""
            val coverUrl = volumeInfo.imageLinks?.smallThumbnail ?: ""

            val book = Book(
                id = 30 + i,
                title = title,
                author = authors,
                description = description,
                n_pages = nPages,
                isbn = identifier,
                cover_url = coverUrl
                           )
            bookList.add(book)
        }
    }
    return bookList
}












//fun searchRequest2Book(searchRequest: SearchRequest?): MutableList<Book> {
//
//    var bookList: MutableList<Book> = mutableListOf()
//
//    for (i in 0 until 7) {
//        if (searchRequest != null) {
//            bookList.add(
//                Book(
//                    id = 30 + i,
//                    title = searchRequest.items[i].volumeInfo.title ?:  "",
//                    author = searchRequest.items[i].volumeInfo.authors[0] ?: "",
//                    description = searchRequest.items[i].volumeInfo.description ?: "",
//                    n_pages = searchRequest.items[i].volumeInfo.pageCount ?: 0,
//                    isbn = searchRequest.items[i].volumeInfo.industryIdentifiers[0].identifier ?: "", // Index 1 is ISBN-1i which is not as used,
//                    //                    isbn = "8968",
//                    cover_url = searchRequest.items[i].volumeInfo.imageLinks.thumbnail ?: "",
//                    )
//                        )
//        }
//    }
//    return bookList
//}
//    searchRequest?.let { list ->
//        for (item in list.items) {
//            bookList.add(
//                Book(
//                    title = item.volumeInfo.title,
//                    author = item.volumeInfo.authors[0],
//                    description = item.volumeInfo.description,
//                    n_pages = item.volumeInfo.pageCount,
//                    isbn = item.volumeInfo.industryIdentifiers[0].identifier, // Index 1 is ISBN-10 which is not as used,
////                    isbn = "8968",
//                    cover_url = item.volumeInfo.imageLinks.thumbnail,
//                    )
//
//                        )
//        }
//    }

//        for (i in 0 until 5) {
//            if (searchRequest != null) {
//                bookList.add(
//                    Book(
//                        id = i+30,
//                        title = searchRequest.items[i].volumeInfo.title,
//                        author = searchRequest.items[i].volumeInfo.authors[0],
//                        description = searchRequest.items[i].volumeInfo.description,
//                        n_pages = searchRequest.items[i].volumeInfo.pageCount,
//                        isbn = searchRequest.items[i].volumeInfo.industryIdentifiers[0].identifier, // Index 1 is ISBN-10 which is not as used,
//        //                    isbn = "8968",
//                        cover_url = searchRequest.items[i].volumeInfo.imageLinks.thumbnail,
//                        )
//
//                            )
//            }
//        }
