package Lab2

// Напишите свои решения в виде функций.
object RecursiveData {
    // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
    def ListIntEmpty(list: List[Int]): Boolean = {
        val opt = Option[List[Int]](list)
        opt.filter(_.nonEmpty).isEmpty
    }

    // Используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
    def testListIntEmpty(list: List[Int]): Boolean = ListIntEmpty(list)

    // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
    def ListIntHead(list: List[Int]): Int = {
        if (ListIntEmpty(list)) -1
        else list.head
    }

    // Используйте функцию из пункта (b) здесь, не изменяйте сигнатуру
    def testListIntHead(list: List[Int]): Int = ListIntHead(list)

    // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
    // Имеется в виду это решение?
    // sealed trait List[A]
    // case class Cons[A](head: A, tail: List[A]) extends List[A]
    // case class Nil[A]() extends List[A]

    /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
     *      node - левое и правое дерево (Tree)
     *      leaf - переменная типа A
     */
    class Tree[A](var leaf: A, var leftNode: Tree[A], var rightNode: Tree[A]) {
        /*
        def AddElement(val value: A) = {
            var a = leftNode
            var b = rightNode
            while(a != null || b != null) {
                if (a.leftNode == null || a.rightNode == null)
            }
        }
        */
        def SetRightNode(rNode: Tree[A]) = (rightNode = rNode)
        def SetLeftNode(lNode: Tree[A]) = (leftNode = lNode)
    }
     
     // Точка входа в программу
     def main(args: Array[String]) = {
        println("Task a")
        println(testListIntEmpty(List(1, 2, 3)))
        println(testListIntEmpty(List()))
        println(testListIntEmpty(null))
        
        println("\nTask b")
        println(testListIntHead(List(300, 200, 100)))
        println(testListIntHead(List()))
        println(testListIntHead(null))
        
        println("\nTask d")
        var t = Tree(1, Tree(2, null, null), Tree(3, null, null))
        t.leftNode.SetRightNode(Tree(4, null, null))
        println(t)
     }
}
