package com.example.facesofopensource.data

import com.example.facesofopensource.R

data class Person(val nome: String, val desc: String, val imagem: Int)

object DataSource {
    val people = listOf(
        Person("Ken Tompson",
            "Ken Thompson designed and implemented the Unix operating system while working at Bell Labs. He is also the creator of the B programming language as well as UTF-8 encoding – which made it possible for computers to display and exchange data in multiple languages. Later in his career, Thompson also co-invented the Go programming language.",
            R.drawable.ken_thompson),
        Person("Linus Torvalds",
            "Linus Torvalds invented the Linux operating system which is used to run the vast majority of computer servers connected to the Internet. Torvalds also invented the Git version control system which he uses to manage the source code changes made to Linux by thousands of open source developers.",
            R.drawable.linus_torvalds),
        Person("Steve Bourne",
            "Steve Bourne created the Bourne shell (sh) and other Unix tools as a researcher at Bell Labs. The Bourne shell became Unix’s default shell in Version 7 Unix (replacing the original shell written by Ken Thompson) and introduced the concept of “shell scripting” by adding programming capabilities to the command-line interpreter.",
            R.drawable.steve_bourne),
        Person("Guido van Rossum",
            "Guido van Rossum is the creator of the Python programming language. Van Rossum holds the title of “Benevolent Dictator for Life” within the Python community which uses a collaborative open source development model to create new versions of the programming language.",
            R.drawable.guido_rossum),
        Person("Brendan Eich",
            "Brendan Eich is a computer scientist and the creator of the JavaScript programming language. In addition, Eich co-founded the Mozilla project which manages the open source development of the Firefox web browser. He is also the CEO and co-founder of Brave Software, a start-up that is building an open source, privacy-focused browser, as well as a blockchain-based digital advertising platform.",
            R.drawable.brendan_eich),
        Person("James Gosling",
            "James Gosling is a Canadian computer scientist best known for inventing the Java programming language and virtual machine. Initially named “Oak” after a tree outside his office at Sun Microsystems, Java today has multiple open source distributions including OpenJDK and Amazon",
            R.drawable.james_gosling)
    )
}