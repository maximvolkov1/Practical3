fun main(args: Array<String>) {
      //Задача 1
      println(agoToText(50))
      println(agoToText(3200))
      println(agoToText(39000))
      println(agoToText(90000))
      println(agoToText(180000))
      println(agoToText(259500))
    println("_________________________________________________________________________")
        main()
}



fun agoToText(SecondsHavePassed: Int): String {
 return when  {
  SecondsHavePassed in 0..60 -> "был(а) только что"
  SecondsHavePassed in 61..3600 -> minutesAgo(SecondsHavePassed)
  SecondsHavePassed in 3601..86400 -> hoursAgo(SecondsHavePassed)
  SecondsHavePassed in 86401..172800 -> "вчера"
  SecondsHavePassed in 172801..259200 -> "позавчера"
  else -> "давно"
 }
}
 fun minutesAgo(seconds: Int): String {
  val minutes = seconds / 60
  val lastDigit = minutes % 10
  return "был(а) в сети $minutes ${if (minutes in 11..14 || lastDigit == 0 || lastDigit in 5..9) "минут" 
  else if (lastDigit == 1) "минуту" else "минуты"} назад"
 }

 fun hoursAgo(seconds: Int): String {
  val hours = seconds / 3600
  val lastDigit = hours % 10
  return "был(а) в сети $hours ${if (hours in 11..14 || lastDigit == 0 || lastDigit in 5..9) "часов" else if 
          (lastDigit == 1) "час" else "часа"} назад"
 }
//______________________________________________________________________________________________________________________
// Задача №2
fun main() {
    val amountTransfer = 200000
    val cardType1 = "Visa"
    val cardType2 = "VK Pay"
    val cardType3 = "Мир"
    val cardType4 = "Maestro"
    val cardType5 = "MasterCard"
    val previousTransfers = 80000
    val commission1 = calculateCommission(cardType1, previousTransfers, amountTransfer)
    val commission2 = calculateCommission(cardType2, previousTransfers, amountTransfer)
    val commission3 = calculateCommission(cardType3, previousTransfers, amountTransfer)
    val commission4 = calculateCommission(cardType4, previousTransfers, amountTransfer)
    val commission5 = calculateCommission(cardType5, previousTransfers, amountTransfer)
    println("Сумма перевода: $amountTransfer")
    println("Сумма предыдущих переводов в этом месяце: $previousTransfers")
    println("Комиссия Visa и Мир: $commission1 и $commission3 руб")
    println("Комиссия VK Pay: $commission2 руб") //комиссия = 0, т.к. комиссия бесплатна
    println("Комиссия Maestro и MasterCard: $commission4 и $commission5 руб")
}
fun calculateCommission(cardType: String = "VK Pay", previousTransfers: Int = 0, amountTransfer: Int): Any {
    val vkPayCommission = 0
    val mastercardMaestroLimit = 75000
    val visaPercent = 0.0075
    val visaMirMinCommission = 35.0
    val mastercardMaestroCommission = 0.006
    val mastercardMaestroMinCommission = 20.0

    return when (cardType) {
            "MasterCard" -> {
                if (previousTransfers + amountTransfer in 1..mastercardMaestroLimit) 0
                else (mastercardMaestroCommission * amountTransfer) + mastercardMaestroMinCommission
            }

            "Maestro" -> {
                if (previousTransfers + amountTransfer in 1..mastercardMaestroLimit) 0
                else (mastercardMaestroCommission * amountTransfer) + mastercardMaestroMinCommission
            }

            "Visa", "Мир" -> {
                if (visaMirMinCommission * amountTransfer > mastercardMaestroMinCommission)
                return amountTransfer * visaPercent
                 else return visaMirMinCommission
            }

            "VK Pay" -> {
                return (vkPayCommission * amountTransfer)
            }

            else -> {
                println("Некорректный тип карты")
            }
    }
}
















