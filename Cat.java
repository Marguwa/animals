/*
Продвинутое ООП
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или
длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)
 */

public class Cat {

    public static class Dogs extends Animal {

        public Dogs(String name) {
            super("Собака " + name);
            this.runLimit = 500;
            this.swimLimit = 10;
            this.jumpLimit = 0.5;
        }
    }

    public static class Cats extends Animal {

        public Cats(String name) {
            super("Кот " + name);
            this.runLimit = 200;
            //this.swimLimit = 0;
            this.jumpLimit = 2;
        }
    }

    public abstract static class Animal {
        protected String name;
        protected int runLimit = 0;
        protected int swimLimit = 0;
        protected double jumpLimit = 0;

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

        public void swim(int distance) {
            if (swimLimit >= 0 && distance <= swimLimit) {
                System.out.println(this.name + " проплыл " + distance + " метров");
            } else {
                System.out.println(this.name + " не может так быстро плыть");
            }
        }

        public void jump(double height) {
            if (jumpLimit >= 0 && height <= jumpLimit) {
                System.out.println(this.name + " прыгнул на " + height + " метров");
            } else {
                System.out.println(this.name + " не может так высоко прыгать");
            }
        }

        public static void main(String[] args) {

            Animal[] arrAnns1 = new Animal[1];
            arrAnns1[0] = new Dogs("Rex");

            for (Animal animal : arrAnns1) {
                animal.run(152);
                animal.swim(2);
                animal.jump(1.45);
            }
            System.out.println("------------------------");

            Animal[] arrAnns2 = new Animal[1];
            arrAnns2[0] = new Cats("Mavrik");

            for (Animal animal : arrAnns2) {
                animal.run(52);
                animal.jump(2.45);
            }
            System.out.println("------------------------");

            Animal[] arrAnns3 = new Animal[1];
            arrAnns3[0] = new Dogs("Belka");
            for (Animal animal : arrAnns3) {
                animal.run(252);
                animal.swim(10);
                animal.jump(0.45);
            }
            System.out.println("------------------------");

            Animal[] arrAnns4 = new Animal[1];
            arrAnns4[0] = new Cats("Murka");
            for (Animal animal : arrAnns4) {
                animal.run(150);
                animal.jump(2);
            }
        }
    }
}


