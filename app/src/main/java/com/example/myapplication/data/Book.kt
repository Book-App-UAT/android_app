package com.example.myapplication.data

import android.os.Parcelable
import com.example.myapplication.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val title: String,
    val author: String, // Author could be its own data class
    val description: String,
    val n_pages: Int,
    val isbn: String,
    val cover_id: Int // From drawables, the painterResource also takes input int
               ) : Parcelable {

    fun doesMatchSearchQuery(query : String): Boolean{
        val matchingCombinations = listOf<String>(
            // TODO Add more variations
            title
                                                 )


        return matchingCombinations.any{
            it.contains(query, ignoreCase = true)
        }

    }

}

val book_data_base = listOf<Book>(
    Book(
        title = "The Psychology of Money",
        author = "Morgan Housel",
        n_pages = 252,
        isbn = "9780857197689",
        cover_id = R.drawable.psychology_of_money_cover,
        description = "Doing well with money isn't necessarily about what you know. It's about how you behave. And behavior is hard to teach, even to really smart people. Money--investing, personal finance, and business decisions--is typically taught as a math-based field, where data and formulas tell us exactly what to do. But in the real world people don't make financial decisions on a spreadsheet. They make them at the dinner table, or in a meeting room, where personal history, your own unique view of the world, ego, pride, marketing, and odd incentives are scrambled together. In The Psychology of Money, award-winning author Morgan Housel shares 19 short stories exploring the strange ways people think about money and teaches you how to make better sense of one of life's most important topics."
        ),

    Book(
        title = "Atomic Habits",
        author = "James Clear",
        n_pages = 319,
        isbn = "9781847941831",
        cover_id = R.drawable.atomic_habits_cover,
        description = "No matter your goals, Atomic Habits offers a proven framework for improving—every day. James Clear, one of the world's leading experts on habit formation, reveals practical strategies that will teach you exactly how to form good habits, break bad ones, and master the tiny behaviors that lead to remarkable results.\n" +
                "\n" +
                "If you're having trouble changing your habits, the problem isn't you. The problem is your system. Bad habits repeat themselves again and again not because you don't want to change, but because you have the wrong system for change. You do not rise to the level of your goals. You fall to the level of your systems. Here, you'll get a proven system that can take you to new heights.\n" +
                "\n" +
                "Clear is known for his ability to distill complex topics into simple behaviors that can be easily applied to daily life and work. Here, he draws on the most proven ideas from biology, psychology, and neuroscience to create an easy-to-understand guide for making good habits inevitable and bad habits impossible. Along the way, readers will be inspired and entertained with true stories from Olympic gold medalists, award-winning artists, business leaders, life-saving physicians, and star comedians who have used the science of small habits to master their craft and vault to the top of their field.\n" +
                "\n" +
                "Learn how to:\n" +
                "- Make time for new habits (even when life gets crazy);\n" +
                "- Overcome a lack of motivation and willpower;\n" +
                "- Design your environment to make success easier;\n" +
                "- Get back on track when you fall off course;\n" +
                "...and much more.\n" +
                "\n" +
                "Atomic Habits will reshape the way you think about progress and success, and give you the tools and strategies you need to transform your habits--whether you are a team looking to win a championship, an organization hoping to redefine an industry, or simply an individual who wishes to quit smoking, lose weight, reduce stress, or achieve any other goal."
        ),

    Book(
        title = "Dune",
        author = "Frank Herbert",
        n_pages = 658,
        isbn = "9780593099322",
        cover_id = R.drawable.dune_cover,
        description = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...\n" +
                "\n" +
                "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a journey toward a destiny greater than he could ever have imagined. And as he evolves into the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most ancient and unattainable dream."
        ),

    )
