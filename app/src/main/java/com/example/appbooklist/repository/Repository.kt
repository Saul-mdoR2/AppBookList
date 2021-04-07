package com.example.appbooklist.repository

import android.content.Context
import com.example.appbooklist.R
import com.example.appbooklist.model.Book

object Repository {
    var bookList = ArrayList<Book>()


    fun createList(): ArrayList<Book> {
        bookList = ArrayList()
        bookList.add(
            Book(
                cover = R.drawable.cover1,
                title = "Chain of Gold",
                author = "Cassandra Clare",
                synopsis = "Cordelia Carstairs is a Shadowhunter, a warrior trained since childhood to battle demons. When her father is accused of a terrible crime, she and her brother travel to London in hopes of preventing the family ruin. Cordelia's mother wants to marry her off, but Cordelia is determined to be a hero rather than a bride. Soon Cordelia encounters childhood friends James and Lucie Herondale and is drawn into their world of glittering ballrooms, secret assignations, and supernatural salons, where vampires and warlocks mingle with mermaids and magicians. All the while, she must hide her secret love for James, who is sworn to marry someone else.But Cordelia new life is blown apart when a shocking series of demon attacks devastate London. These monsters are nothing like those Shadowhunters have fought before—these demons walk in daylight, strike down the unwary with incurable poison, and seem impossible to kill. London is immediately quarantined. Trapped in the city, Cordelia and her friends discover that their own connection to a dark legacy has gifted them with incredible powers—and forced a brutal choice that will reveal the true cruel price of being a hero. "
            )
        )
        bookList.add(
            Book(
                cover = R.drawable.cover2,
                title = "It",
                author = "Stephen King",
                synopsis = "Welcome to Derry, Maine. It  is a small city, a place as hauntingly familiar as your own hometown. Only in Derry the haunting is real.They were seven teenagers when they first stumbled upon the horror. Now they are grown-up men and women who have gone out into the big world to gain success and happiness. But the promise they made twenty-eight years ago calls them reunite in the same place where, as teenagers, they battled an evil creature that preyed on the city's children. Now, children are being murdered again and their repressed memories of that terrifying summer return as they prepare to once again battle the monster lurking in Derry's sewers."
            )
        )
        bookList.add(
            Book(
                cover = R.drawable.cover3,
                title = "Inferno",
                author =  "Dan Brown",
                synopsis = "Florence: Harvard symbologist Robert Langdon awakes in a hospital bed with no recollection of where he is or how he got there. Nor can he explain the origin of the macabre object that is found hidden in his belongings.A threat to his life will propel him and a young doctor, Sienna Brooks, into a breakneck chase across the city. Only Langdon\\’s knowledge of the hidden passageways and ancient secrets that lie behind its historic facade can save them from the clutches of their unknown pursuers.With only a few lines from Dante’s The Inferno to guide them, they must decipher a sequence of codes buried deep within some of the Renaissance’s most celebrated artworks to find the answers to a puzzle which may, or may not, help them save the world from a terrifying threat…"
            )
        )
        bookList.add(
            Book(
                cover =  R.drawable.cover4,
                title = "11/22/63",
                author =   "Stephen King",
                synopsis = "ON NOVEMBER 22, 1963, THREE SHOTS RANG OUT IN DALLAS, PRESIDENT KENNEDY DIED, AND THE WORLD CHANGED. WHAT IF YOU COULD CHANGE IT BACK? In this brilliantly conceived tour de force, Stephen King—who has absorbed the social, political, and popular culture of his generation more imaginatively and thoroughly than any other writer—takes readers on an incredible journey into the past and the possibility of altering it.It begins with Jake Epping, a thirty-five-year-old English teacher in Lisbon Falls, Maine, who makes extra money teaching GED classes. He asks his students to write about an event that changed their lives, and one essay blows him away—a gruesome, harrowing story about the night more than fifty years ago when Harry Dunning's father came home and killed his mother, his sister, and his brother with a sledgehammer. Reading the essay is a watershed moment for Jake, his life—like Harry's, like America's in 1963—turning on a dime. Not much later his friend Al, who owns the local diner, divulges a secret: his storeroom is a portal to the past, a particular day in 1958. And Al enlists Jake to take over the mission that has become his obsession—to prevent the Kennedy assassination.So begins Jake's new life as George Amberson, in a different world of Ike and JFK and Elvis, of big American cars and sock hops and cigarette smoke everywhere. From the dank little city of Derry, Maine (where there's Dunning business to conduct), to the warmhearted small town of Jodie, Texas, where Jake falls dangerously in love, every turn is leading eventually, of course, to a troubled loner named Lee Harvey Oswald and to Dallas, where the past becomes heart-stoppingly suspenseful, and where history might not be history anymore. Time-travel has never been so believable. Or so terrifying."
            )
        )
        bookList.add(
            Book(
                cover = R.drawable.cover5,
                title =  "World War Z",
                author =    "Max Brooks",
                synopsis = "We survived the zombie apocalypse, but how many of us are still haunted by that terrible time? We have (temporarily?) defeated the living dead, but at what cost? Told in the haunting and riveting voices of the men and women who witnessed the horror firsthand, World War Z is the only record of the pandemic.The Zombie War came unthinkably close to eradicating humanity. Max Brooks, driven by the urgency of preserving the acid-etched first-hand experiences of the survivors, traveled across the United States of America and throughout the world, from decimated cities that once teemed with upwards of thirty million souls to the most remote and inhospitable areas of the planet. He recorded the testimony of men, women, and sometimes children who came face-to-face with the living, or at least the undead, hell of that dreadful time. World War Z is the result. Never before have we had access to a document that so powerfully conveys the depth of fear and horror, and also the ineradicable spirit of resistance, that gripped human society through the plague years."
            )
        )
        bookList.add(
            Book(
                cover =  R.drawable.cover6,
                title =  "Mr. Mercedes",
                author = "Stephen King",
                synopsis = "The stolen Mercedes emerges from the pre-dawn fog and plows through a crowd of men and women on line for a job fair in a distressed American city. Then the lone driver backs up, charges again, and speeds off, leaving eight dead and more wounded. The case goes unsolved and ex-cop Bill Hodges is out of hope when he gets a letter from a man who loved the feel of death under the Mercedes\\'s wheels…Brady Hartsfield wants that rush again, but this time he\\'s going big, with an attack that would take down thousands—unless Hodges and two new unusual allies he picks up along the way can throw a wrench in Hartsfield's diabolical plans. Stephen King takes off on a nerve-shredding, pulse-pounding race against time (Fort Worth Star-Telegram) with this acclaimed #1 bestselling thriller."
            )
        )

        return bookList
    }

    fun getDetailsById(bookId: String): Book? {
        return bookList.firstOrNull { it.bookId == bookId }
    }
}