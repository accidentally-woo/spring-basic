package playground.calculator.check;

interface Predator {
}

class Animal {
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
}

class Sample {
    public static void main(String[] args) {
        Animal a = new Animal();  // 1번
        Animal b = new Dog();  // 2번
        Animal c = new Lion();  // 3번
//        Dog d = new Animal();  // 4번 IS-A 관계
        Predator e = new Lion();  // 5번
    }
}