
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


