package Lab2

/* Option представляет собой контейнер, который хранит какое-то значение 
 * или не хранит ничего совсем, указывает, вернула ли операция результат или нет. 
 * Это часто используется при поиске значений или когда операции могут потерпеть неудачу, 
 * и вам не важна причина.
 *
 * Комбинаторы называются так потому, что они созданы, чтобы объединять результаты. 
 * Результат одной функции часто используется в качестве входных данных для другой.
 *
 * Наиболее распространенным способом, является использование их со стандартными структурами данных.
 * Функциональные комбинаторы `map` и` flatMap` являются контекстно-зависимыми. 
 * map - применяет функцию к каждому элементу из списка, возвращается список с тем же числом элементов.
 * flatMap берет функцию, которая работает с вложенными списками и объединяет результаты.
 */
/*
sealed trait Option[A] {
    def map[B](f: A => B): Option[B]
    def flatMap[B](f: A => Option[B]): Option[B]
}
case class Some[A](a: A) extends Option[A] {
    def map[B](f: A => B): Option[B] = Some(f(a))
    def flatMap[B](f: A => Option[B]): Option[B] = f(a)
}
case class None[A]()     extends Option[A] {
    def map[B](f: A => B): Option[B] = None()
    def flatMap[B](f: A => Option[B]): Option[B] = None()
}
*/

// Напишите ваши решения в тестовых функциях.
object Compositions {
    // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.
    // Нельзя менять сигнатуры 
    def testCompose[A, B, C, D](f: A => B)
                               (g: B => C)
                               (h: C => D): A => D = {
        h compose g compose f
    }

    // b) Напишите функции с использованием `map` и `flatMap`.
    // Вы можете реализовать свое решение прямо в тестовой функции.
    // Нельзя менять сигнатуры 
    def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                  (g: B => Option[C])
                                  (h: C => D): Option[A] => Option[D] = {
        a => a flatMap f flatMap g map h
        // _.flatMap(f).flatMap(g).map(h)
    }

    // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции.
    // Нельзя менять сигнатуры 
    def testForComprehension[A, B, C, D](f: A => Option[B])
                                        (g: B => Option[C])
                                        (h: C => D): Option[A] => Option[D] = {
        for {
            a <- _
            b <- f(a)
            c <- g(b)
        } yield h(c)
    }
    
    // Точка входа в программу
    def main(args: Array[String]) = {
        println("Task a")
        println(testCompose((str: String) => str.toInt)((num: Int) => num.toLong)((num: Long) => num.toDouble)("123"))
        println("\nTask b")
        println(testMapFlatMap((in: Int) => Some(in / 5))((in: Int) => Some(in.toString))((in: String) => in.toList)(Some(500)))
        println("\nTask c")
        println(testForComprehension((in: Int) => Some(in + 3))((_: Int) => None)((in: Int) => in - 3)(Some(123)))
    }
}
