/*
Задачи на взаимодействие классов:
1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;
2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;
7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
*/

public class Cat {

    public static class Cats extends Animal {

        public Cats(String name) {
            super("Кот " + name);
            this.appetite = 50;
            this.isFull = false;
            this.runLimit = 200;
            this.jumpLimit = 2;
        }
    }

    public abstract static class Animal {
        protected String name;
        protected int appetite = 0;
        protected boolean isFull;
        protected int runLimit = 0;
        protected double jumpLimit = 0;

        public Animal() {
            this.name = "Безимянный";
        }

        public Animal(String name) {
            this.name = name;
        }

        public void run(int distance) {
            if (runLimit >= 0 && distance <= runLimit) {
                System.out.println(this.name + " пробежал " + distance + " метров");
            } else {
                System.out.println(this.name + " не может так быстро бегать");
            }
        }

        public void jump(double height) {
            if (jumpLimit >= 0 && height <= jumpLimit) {
                System.out.println(this.name + " прыгнул на " + height);
            } else {
                System.out.println(this.name + " не может так высоко прыгать");
            }
        }

        public void eat(Plate plate) {
            if (plate.getAmountOfFood() > appetite) {
                plate.decreaseFood(appetite);
                isFull = true;
                System.out.println(this.name + " сьел " + appetite);
                System.out.println(this.name + " сыт");
            } else {
                System.out.println("Еда в миске закончилась");
                System.out.println(this.name + " голоден");
                plate.increaseFood(100);
            }
        }

        public static void main(String[] args) {
            Plate plate = new Plate(100);
            Animal[] arrAnns = new Animal[3];

            arrAnns[0] = new Cats("Vasiliy");
            for (Animal animal : arrAnns) {
                animal.run(152);
                animal.jump(1.45);
                animal.eat(plate);
            }
            System.out.println("------------------------");

            arrAnns[1] = new Cats("Mavrik");
            for (Animal animal : arrAnns) {
                animal.run(52);
                animal.jump(2.45);
                animal.eat(plate);
            }
            System.out.println("------------------------");

            arrAnns[2] = new Cats("Mursik");
            for (Animal animal : arrAnns) {
                animal.run(252);
                animal.jump(0.45);
                animal.eat(plate);
            }
        }
    }
}


